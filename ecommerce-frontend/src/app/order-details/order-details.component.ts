import { Component, OnInit } from '@angular/core';
import { Invoice } from 'src/app/common/invoice';
import { InvoiceService } from 'src/app/services/invoice.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  invoices: Invoice[];

  constructor(private invoiceService:InvoiceService) { 
    this.invoices = [];
  }

  ngOnInit(): void {
    this.invoiceService.getInvoiceList().subscribe(data => {
      this.invoices = data;
    });
  }

}
