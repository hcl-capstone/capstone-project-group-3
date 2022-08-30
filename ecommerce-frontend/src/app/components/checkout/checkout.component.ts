import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/common/address';
import { Invoice } from 'src/app/common/invoice';
import { AddressService } from 'src/app/services/address.service';
import { InvoiceService } from 'src/app/services/invoice.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  invoice:Invoice = {}; 
  address:Address; 
  id = ''; 

  constructor(private invoiceService: InvoiceService, private addressService: AddressService) { 
    this.invoice = {}; 
    this.address = {}; 
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
}
