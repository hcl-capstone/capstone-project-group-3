import { Component, Inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { OrderStatusService } from 'src/app/services/order-status.service';
import { ProductService } from 'src/app/services/product.service';
import { OrderStatusComponent } from '../order-status/order-status.component';
import { Product } from 'src/app/common/product';
import { CartDetails } from 'src/app/common/cart-details';
import { CartDetailsService } from 'src/app/services/cart-details.service';
import { OktaAuth } from '@okta/okta-auth-js';
import { OKTA_AUTH } from '@okta/okta-angular';
import { User } from "src/app/common/user"; 
import { UserService } from 'src/app/services/user.service';
import { Invoice } from 'src/app/common/invoice';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit {


  id?: number;
  prod?: Product;
  claims!: { name: string; value: unknown }[];
  sub: string; 
  isAuthenticated!: boolean;
  user?:User;
  invoices?:Invoice[];
  invoice: Invoice;  
  carts?:ShoppingCart[];  

  constructor(private cartDetailsService: CartDetailsService, private route: ActivatedRoute, @Inject(OKTA_AUTH) public oktaAuth: OktaAuth,  public userService: UserService) {
  
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

      this.carts = this.invoice.carts; 
  
      console.log(this.user, this.invoice); 
    },
    error: (e) => console.error(e)
    })

    var x = this.route.snapshot.paramMap.get('id');
    if(x != null){
      var y = +x;
      this.id = y;

      this.cartDetailsService.getCarts(this.id).subscribe((data: CartDetails[]) => {
        this.carts = data;
        console.log('these are the carts: ' + this.carts);
        console.log('2nd ');
      });
    }
    else{
      this.cartDetailsService.getCarts(1).subscribe((data: CartDetails[]) => {
        this.carts = data;
      });
    }
   }



}
