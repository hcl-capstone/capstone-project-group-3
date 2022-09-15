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
  ImagePath: string;

  paymentHandler:any = null;

  constructor(private invoiceService: InvoiceService, private addressService: AddressService , private shoppingCartService:ShoppingCartService) { 
    this.invoice; 
    this.address = {}; 
    this.carts = []; 
  }

  ngOnInit() {
    this.invokeStripe();
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
  

 

  
  
  initializePayment(amount: number | undefined) {
    const paymentHandler = (<any>window).StripeCheckout.configure({
      key: 'pk_test_51LhETxEgAjpp2DzimLBoNsy75SlfLYDR9vRq2HfRKIncxa939QQM7a72SaTIofHqonNrhfwy8SFWy7KTP7gbV7Ze00qlTexV2u',
      locale: 'auto',
      token: function (stripeToken: any) {
        console.log({stripeToken})
        alert('your order has been placed check your email for a conformation!');
      }
    });
  
    paymentHandler.open({
      image: 'https://res.cloudinary.com/du6vcjz7b/image/upload/v1663189011/peach-removebg-preview_dyy9jx.png',
      name: 'Fruitilicious',
      description: 'Exotic fruits',
      amount: Number(amount) * 100
      
    });
  }
  
  invokeStripe() {
    if(!window.document.getElementById('stripe-script')) {
      const script = window.document.createElement("script");
      script.id = "stripe-script";
      script.type = "text/javascript";
      script.src = "https://checkout.stripe.com/checkout.js";
      script.onload = () => {
        this.paymentHandler = (<any>window).StripeCheckout.configure({
          key: 'pk_test_51LhETxEgAjpp2DzimLBoNsy75SlfLYDR9vRq2HfRKIncxa939QQM7a72SaTIofHqonNrhfwy8SFWy7KTP7gbV7Ze00qlTexV2u',
          locale: 'auto',
          token: function (stripeToken: any) {
            console.log(stripeToken)
            alert('Payment has been successfull!');
          }
        });
      }
      window.document.body.appendChild(script);
    }
  }
}
