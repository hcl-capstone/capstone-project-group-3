import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/common/address';
import { Invoice } from 'src/app/common/invoice';
import { OrderStatus } from 'src/app/common/order-status';
import { OrderStatusService } from 'src/app/services/order-status.service';
import { AddressService } from 'src/app/services/address.service';
import { InvoiceService } from 'src/app/services/invoice.service';

@Component({
  selector: 'app-order-status',
  templateUrl: './order-status.component.html',
  styleUrls: ['./order-status.component.css']
})
export class OrderStatusComponent implements OnInit {

  // carts?: ShoppingCart;
  // productQuantity?: number;
  // totalPrice: 0;
  // address?: Address;
  // dateOrdered?: Date;
  invoices:Invoice[];
  address:Address| undefined;
  id:string;


  constructor(private orderStatusService:OrderStatusService) { 
    this.invoices;
    this.address = {};
  }

  ngOnInit(): void {

  }

  getInvoices(): void {
    this.orderStatusService.getInvoices(this.id).subscribe(data => {
      this.invoices = data;
    })
  //   this.orderStatusService.getInvoices(this.id)
  //   .subscribe({
  //     next: (data) => {
  //       this.invoice = data;
  //       console.log(this.invoice);
  //     },
  //     error: (e: any) => console.error(e)

  //   })
  }

}
