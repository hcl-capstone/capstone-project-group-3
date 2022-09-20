import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { Address } from 'src/app/common/address';
import { Invoice } from 'src/app/common/invoice';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { User } from 'src/app/common/user';
import { AddressService } from 'src/app/services/address.service';
import { InvoiceService } from 'src/app/services/invoice.service';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';
import { UserService } from 'src/app/services/user.service';
import { UserDetailsComponent } from '../user-details/user-details.component';
import { OktaAuth } from '@okta/okta-auth-js';
import { OKTA_AUTH } from '@okta/okta-angular';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  userDetails:UserDetailsComponent;


  invoice:Invoice; 
  address?:Address[];  
  carts?:ShoppingCart[];  
  id:string | undefined; 
  user?:User;
  email?:string; 
  claims!: { name: string; value: unknown }[];
  sub: string; 
  isAuthenticated!: boolean;


  constructor(private invoiceService: InvoiceService, private addressService: AddressService , private shoppingCartService:ShoppingCartService, @Inject(OKTA_AUTH) public oktaAuth: OktaAuth, public userService: UserService) { 

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
        this.email = this.user.email; 
        this.address = data.address; 
        console.log(this.user, this.address); 
      },
      error: (e) => console.error(e)
    })




  }

  doCheckout(): void {
    this.invoiceService.getCheckout(this.id)
      .subscribe({
        next: (data) => {
          this.invoice = data;
          console.log(this.invoice);
        },
        error: (e) => console.error(e)

      })
  }


  getInvoice(): void {
    this.invoiceService.getInvoice(this.id)
      .subscribe({
        next: (data) => {
          this.invoice = data;
          //this.address = { ...this.invoice.address };
          this.carts = data.carts; 
          console.log(this.invoice, this.address, this.carts); 
        },
        error: (e) => console.error(e)
    })

  }



}
