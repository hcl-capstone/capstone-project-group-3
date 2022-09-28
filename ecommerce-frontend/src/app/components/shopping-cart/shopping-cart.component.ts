import { Component, OnInit, Inject } from '@angular/core';
import { Invoice } from 'src/app/common/invoice';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { InvoiceService } from 'src/app/services/invoice.service';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';
import { HttpClient } from '@angular/common/http';
import { OktaAuth } from '@okta/okta-auth-js';
import { OKTA_AUTH } from '@okta/okta-angular';
import { User } from "src/app/common/user";
import { UserService } from 'src/app/services/user.service';
import { UpdateCartDto } from 'src/app/common/update-cart-dto';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  carts?:ShoppingCart[];
  id:string | undefined;
  shoppingCart: ShoppingCart = {
    productId: 0,
    productQuantity: 1,
    invoiceId: 0
  };
  submitted = false;
  invoices?:Invoice[];
  invoice:Invoice;
  claims!: { name: string; value: unknown }[];
  sub: string;
  isAuthenticated!: boolean;
  user?:User;
  cartDto: UpdateCartDto = {};
  //  productQuantity?: number;

  constructor(private shoppingCartService: ShoppingCartService, private invoiceService:InvoiceService,  @Inject(OKTA_AUTH) public oktaAuth: OktaAuth,  public userService: UserService) { }


  async ngOnInit() {
    const idToken = await this.oktaAuth.tokenManager.get('idToken');
    this.claims = Object.entries(idToken.claims).map(entry => ({ name: entry[0], value: entry[1] }));
    console.log(this.claims);

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

      console.log(this.carts);
    },
    error: (e) => console.error(e)
    })
  }

  updateCart(cart : ShoppingCart): void {
    this.cartDto.productQuantity = cart.productQuantity;
    this.cartDto.cartId = cart.cartId;
    //console.log("Posting Invoice Update...", this.cartDto);
    this.invoiceService.postInvoiceUpdate(this.cartDto)
      .subscribe({
        next: (data: any) => {
          console.log(data);
        },
        error: (e: any) => console.error(e)
      });

  }


  removeShoppingCart(cartId:any): void {
    console.log(cartId);
    console.log(this.shoppingCart.invoiceId);
    this.invoiceService.deleteProduct(this.invoice.invoiceId, cartId)
    .subscribe({
      next: (res: any) => {
        console.log(res);
      },
      error: (e: any) => console.error(e)
    });

  }

}
