import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;

  constructor() { 
    this.title = "Welcome to Checkout"; 
  }
  paymentHandler:any = null;

 

  ngOnInit() {
    this.invokeStripe();
  }
  
  initializePayment(amount: number) {
    const paymentHandler = (<any>window).StripeCheckout.configure({
      key: 'pk_test_51LhETxEgAjpp2DzimLBoNsy75SlfLYDR9vRq2HfRKIncxa939QQM7a72SaTIofHqonNrhfwy8SFWy7KTP7gbV7Ze00qlTexV2u',
      locale: 'auto',
      token: function (stripeToken: any) {
        console.log({stripeToken})
        alert('Stripe token generated!');
      }
    });
  
    paymentHandler.open({
      name: 'Fruitilicious',
      description: 'Exotic fruits',
      amount: amount * 100
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
