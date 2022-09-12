import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/common/address';
import { Invoice } from 'src/app/common/invoice';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { AddressService } from 'src/app/services/address.service';
import { InvoiceService } from 'src/app/services/invoice.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  invoice:Invoice = {}; 
  address:Address | undefined; 
  cart:ShoppingCart | undefined; 
  //carts:ShoppingCart = Array<ShoppingCart>; 
  id = ''; 


  constructor(private invoiceService: InvoiceService, private addressService: AddressService) { 
    this.invoice = {}; 
    this.address = {}; 
    this.cart = {}; 
  }

  ngOnInit(): void {
  }

  doCheckout(): void {
    this.invoiceService.getCheckout(this.id) 
      .subscribe({
        next: (data) => {
          this.invoice = data;
          this.address = { ...this.invoice.address };
          this.cart = { ...this.invoice.carts };
          console.log(this.invoice, this.address, this.cart); 
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
          this.cart = { ...this.invoice.carts };
          console.log(this.invoice, this.address, this.cart); 
        },
        error: (e) => console.error(e)
    })
  }
}
