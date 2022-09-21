import { Component, OnInit, Inject } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { OktaAuth } from '@okta/okta-auth-js';
import { OKTA_AUTH } from '@okta/okta-angular';
import { User } from "src/app/common/user"; 
import { UserService } from 'src/app/services/user.service';
import { Invoice } from 'src/app/common/invoice';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  invoices?:Invoice[];
  invoice: Invoice;  
  claims!: { name: string; value: unknown }[];
  sub: string; 
  isAuthenticated!: boolean;
  carts?:ShoppingCart[]; 
  user?:User;
  shoppingCart: ShoppingCart = {
    productId: 0,
    productQuantity: 1,
    invoiceId: 1
  };

  constructor(private shoppingCartService: ShoppingCartService, private productService:ProductService, @Inject(OKTA_AUTH) public oktaAuth: OktaAuth,  public userService: UserService) { }

  async ngOnInit() {
    this.productService.getProductList().subscribe(data => {
      this.products = data;
    });

    const idToken = await this.oktaAuth.tokenManager.get('idToken');
    this.claims = Object.entries(idToken.claims).map(entry => ({ name: entry[0], value: entry[1] }));

    this.isAuthenticated = await this.oktaAuth.isAuthenticated();
    if (this.isAuthenticated) {
      const userClaims = await this.oktaAuth.getUser();
      this.sub = userClaims.sub; 
    }
  
    this.userService.getByIdToken(this.sub)
    .subscribe({
      next: (data) => {
      this.user = data;
      this.invoices = data.invoices; 
      if(this.invoices != null){
        this.invoice = this.invoices[0]; 
      } 

      this.carts = this.invoice.carts; 
  
      console.log(this.user, this.invoice); 
    },
    error: (e) => console.error(e)
    })
  }


  saveShoppingCart(): void {
    const data = {
      productQuantity: this.shoppingCart.productQuantity,
      productId: this.shoppingCart.productId
      
    };

    this.shoppingCartService.addToCart(this.invoice.invoiceId, data)
      .subscribe({
        next: (res: any) => {
          console.log(res);
        },
        error: (e: any) => console.error(e)
      });
  }
}
