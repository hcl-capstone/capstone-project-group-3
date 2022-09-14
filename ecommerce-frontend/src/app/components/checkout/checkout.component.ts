import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/common/address';
import { Invoice } from 'src/app/common/invoice';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { AddressService } from 'src/app/services/address.service';
import { InvoiceService } from 'src/app/services/invoice.service';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  invoice:Invoice; 
  address:Address | undefined; 
  carts?:ShoppingCart[];  
  id:string; 


  constructor(private invoiceService: InvoiceService, private addressService: AddressService , private shoppingCartService:ShoppingCartService) { 
    this.invoice; 
    this.address = {}; 
    this.carts = []; 
  }

  ngOnInit(): void {
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
