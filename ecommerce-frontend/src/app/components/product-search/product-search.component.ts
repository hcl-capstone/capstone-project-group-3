import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
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
  selector: 'app-product-search',
  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.css']
})
export class ProductSearchComponent implements OnInit {
  products:Product[];
  currentTutorial: Product = {};
  currentIndex = -1;
  productName = '';
  shoppingCart: ShoppingCart = {
    productId: 0,
    productQuantity: 1,
    invoiceId: 1
  };
  invoices?:Invoice[];
  invoice: Invoice;  
  claims!: { name: string; value: unknown }[];
  sub: string; 
  isAuthenticated!: boolean;
  user?:User;



  constructor(private shoppingCartService: ShoppingCartService,private productService: ProductService, @Inject(OKTA_AUTH) public oktaAuth: OktaAuth,  public userService: UserService) {
    this.products = [];
  }

  async ngOnInit() {
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
      console.log(this.user, this.invoice); 
    },
    error: (e) => console.error(e)
    })
  }

  doSearch(): void {
    this.currentTutorial = {};
    this.currentIndex = -1;

    this.productService.findByProductName(this.productName)
      .subscribe({
        next: (data) => {
          this.products = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  saveShoppingCart(id: any): void {
    const data = {
      productQuantity: 1,
      productId: id
      
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
