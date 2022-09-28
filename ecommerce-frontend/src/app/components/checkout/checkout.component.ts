import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { Address } from 'src/app/common/address';
import { Invoice } from 'src/app/common/invoice';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { AddressService } from 'src/app/services/address.service';
import { InvoiceService } from 'src/app/services/invoice.service';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';
import { UserService } from 'src/app/services/user.service';
import { UserDetailsComponent } from '../user-details/user-details.component';
import { OktaAuth } from '@okta/okta-auth-js';
import { OKTA_AUTH } from '@okta/okta-angular';
import { User } from "src/app/common/user"; 
import { PromoServiceTsService } from 'src/app/services/promo.service.ts.service';
import { Promo } from 'src/app/common/promo';
import { waitForAsync } from '@angular/core/testing';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  userDetails:UserDetailsComponent;

  promo: Promo = {
    promoCode: "",
    discount: 0
  };
  invoices?:Invoice[];
  invoice: Invoice = {};  
  address?:Address[];  
  add?:Address;
  carts?:ShoppingCart[];  
  id:string | undefined; 
  user:User;
  email?:string; 
  claims!: { name: string; value: unknown }[];
  sub: string; 
  isAuthenticated!: boolean;
  name?: string;
  paymentHandler:any = null;

  constructor(private toastr: ToastrService, private promoService: PromoServiceTsService, private invoiceService: InvoiceService, private addressService: AddressService , @Inject(OKTA_AUTH) public oktaAuth: OktaAuth, public userService: UserService) { 

  }

  async ngOnInit() {
    const idToken = await this.oktaAuth.tokenManager.get('idToken');
    this.claims = Object.entries(idToken.claims).map(entry => ({ name: entry[0], value: entry[1] }));

    this.isAuthenticated = await this.oktaAuth.isAuthenticated();
    if (this.isAuthenticated) {
      const userClaims = await this.oktaAuth.getUser();

      this.sub = userClaims.sub; 
    }
  
    this.userService.getByIdToken(this.sub)
    .subscribe({
      next: (data) => {
      this.user = data;
      this.email = this.user.email; 
      this.address = data.address; 
      this.invoices = data.invoices; 
      this.name = this.user.firstName; 
      if(this.user?.address != null){
        this.add = this.user?.address[0]; 
      }
      if(this.invoices != null){
        this.invoice = this.invoices[0]; 
      } 

      this.carts = this.invoice.carts; 
  
      console.log(this.user, this.address, this.name, this.add, this.invoice); 
    },
    error: (e) => console.error(e)
    })
  
    this.invokeStripe();

  }

  doCheckout(): void {
    this.invoiceService.getCheckout(this.id)
      .subscribe({
        next: (data) => {
          //this.invoice = data;
          console.log(this.invoice);
        },
        error: (e) => console.error(e)


      })
  }


  getInvoice(): void {
    this.invoiceService.getInvoice(this.id)
      .subscribe({
        next: (data) => {
          this.carts = data.carts; 
          console.log(this.invoice, this.address, this.carts); 
        },
        error: (e) => console.error(e)
    })
  }

  getIdToken(): void {
    this.userService.getByIdToken(this.sub)
      .subscribe({
        next: (data) => {
        this.user = data;
        this.email = this.user.email; 
        this.address = data.address; 
        this.name = this.user.firstName; 
        console.log(this.user, this.address, this.name); 
      },
      error: (e) => console.error(e)
    })
  }


 
  setPromocode(){
    this.toastr.success("Discount Applied at Checkout!:)");
    this.promoService.findByPromoName(this.promo.promoCode).subscribe({
      next: (data) => {
        this.promo = data;
        console.log(this.promo);
        
      },
      error: (e) => console.error(e)
    });
  };


  initializePayment(amount: number | undefined, code: string | undefined) {
    const paymentHandler = (<any>window).StripeCheckout.configure({
      key: 'pk_test_51LhETxEgAjpp2DzimLBoNsy75SlfLYDR9vRq2HfRKIncxa939QQM7a72SaTIofHqonNrhfwy8SFWy7KTP7gbV7Ze00qlTexV2u',
      locale: 'auto',
      token: function (stripeToken: any) {
        console.log({stripeToken})
        alert('your order has been placed check your email for a confirmation!');
      }
    });
    console.log(this.promo.promoCode);
    
    
    console.log(Number(this.promo.discount));
    paymentHandler.open({
      image: 'https://res.cloudinary.com/du6vcjz7b/image/upload/v1663189011/peach-removebg-preview_dyy9jx.png',
      name: 'Fruitilicious',
      description: 'Exotic fruits',
      amount: Number(amount) * 100 * (1-Number(this.promo.discount))

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