import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Address } from 'src/app/common/address';
import { Invoice } from 'src/app/common/invoice';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { InvoiceService } from 'src/app/services/invoice.service';

@Component({
  selector: 'app-admin-order-details',
  templateUrl: './admin-order-details.component.html',
  styleUrls: ['./admin-order-details.component.css']
})
export class AdminOrderDetailsComponent implements OnInit {

  @Input() viewMode = false;

  @Input() currentInvoice: Invoice= new Invoice();

  message = '';

  constructor(
    private invoiceService: InvoiceService,
    private route: ActivatedRoute,
    private router: Router ) { }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getInvoice(this.route.snapshot.params["id"])
      console.log(`details: ${this.route.snapshot.params["id"]}`);
    }
  }

  getInvoice(id: number): void {
    this.invoiceService.getInvoice(id).subscribe({
      next: (data) =>{
        this.currentInvoice = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    })
  }

  
  toString() : string {
    if(this.currentInvoice.address){
      let addressString = ""+this.currentInvoice.address.street;
      if(this.currentInvoice.address.secondary){
        addressString = addressString + "\n" + this.currentInvoice.address.secondary; 
      }
      addressString = addressString + "\n" 
        + this.currentInvoice.address.city + ", " + this.currentInvoice.address.state + "\n" 
        + this.currentInvoice.address.zip + "\n" 
        + this.currentInvoice.address.country;
      console.log(addressString)
      return addressString;
    }
    return "Address not set"
  }
}
