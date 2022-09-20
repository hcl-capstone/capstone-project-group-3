import { Component, OnInit } from '@angular/core';
import { Invoice } from 'src/app/common/invoice';
import { InvoiceService } from 'src/app/services/invoice.service';

@Component({
  selector: 'app-admin-order-list',
  templateUrl: './admin-order-list.component.html',
  styleUrls: ['./admin-order-list.component.css']
})
export class AdminOrderListComponent implements OnInit {

  invoices: Invoice[] = [];
  invoice : Invoice = {};
  currentInvoice: Invoice = {};
  currentIndex = -1;
  id = 0;

  constructor(private invoiceService : InvoiceService) { }

  ngOnInit(): void {
    this.retrieveInvoices();
  }

  retrieveInvoices(): void {
    console.log("Getting List of Invoices");
    this.invoiceService.getInvoiceList()
      .subscribe({
        next: (data) => {
          this.invoices = data;
          console.log(data);
        }
      })
  }

  setActiveInvoice(invoice: Invoice, index: number): void {
    this.currentInvoice = invoice;
    this.currentIndex = index;
    console.log(index);
  }

}
