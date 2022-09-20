import { Component, OnInit } from '@angular/core';
import { Invoice } from 'src/app/common/invoice';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { InvoiceService } from 'src/app/services/invoice.service';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  carts?:ShoppingCart[];
  id:string | undefined;
  shoppingCart: ShoppingCart = {
    productId: 0,
    productQuantity: 1,
    invoiceId: 0
  };
  submitted = false;

  invoice:Invoice;
  constructor(private shoppingCartService: ShoppingCartService, private invoiceService:InvoiceService) { }


  ngOnInit(): void {
  }

  saveShoppingCart(): void {
    const data = {
      productQuantity: this.shoppingCart.productQuantity,
      productId: this.shoppingCart.productId

    };

    this.shoppingCartService.addToCart(this.shoppingCart.invoiceId, data)
      .subscribe({
        next: (res: any) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e: any) => console.error(e)
      });
  }

  newShoppingCart(): void {
    this.submitted = false;
    this.shoppingCart = {
      productId: 0,
      productQuantity: 0,
      invoiceId: 0
    };
  }


  getInvoice(): void {
    this.invoiceService.getInvoice(this.shoppingCart.invoiceId)
      .subscribe({
        next: (data) => {
          this.carts = data.carts;
          console.log(this.carts);
        },
        error: (e) => console.error(e)
    })

  }

  removeShoppingCart(cartId:any): void {
    console.log(cartId);
    console.log(this.shoppingCart.invoiceId);
    this.invoiceService.deleteProduct(this.shoppingCart.invoiceId, cartId)
    .subscribe({
      next: (res: any) => {
        console.log(res);
      },
      error: (e: any) => console.error(e)
    });
    this.getInvoice();
  }

}
