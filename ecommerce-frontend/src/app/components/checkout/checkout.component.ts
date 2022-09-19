import { Component, OnInit, ViewChild } from '@angular/core';
import { Address } from 'src/app/common/address';
import { Invoice } from 'src/app/common/invoice';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { User } from 'src/app/common/user';
import { AddressService } from 'src/app/services/address.service';
import { InvoiceService } from 'src/app/services/invoice.service';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';
import { UserService } from 'src/app/services/user.service';
import { UserDetailsComponent } from '../user-details/user-details.component';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  userDetails:UserDetailsComponent;


  invoice:Invoice; 
  address:Address | undefined; 
  carts?:ShoppingCart[];  
  id:string | undefined; 
  user:User;
  email:string; 

  constructor(private invoiceService: InvoiceService, private addressService: AddressService , private shoppingCartService:ShoppingCartService) { 
    this.invoice; 
    this.address = {}; 
    this.carts = [];
    this.user;  
  }

  ngOnInit(): void {
  }

  getEmail(): void {
    this.user = this.userDetails.getUserByEmail(this.email); 
    console.log(); 
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
          this.address = { ...this.invoice.address };
          this.carts = data.carts; 
          console.log(this.invoice, this.address, this.carts); 
        },
        error: (e) => console.error(e)
    })

  }



}
