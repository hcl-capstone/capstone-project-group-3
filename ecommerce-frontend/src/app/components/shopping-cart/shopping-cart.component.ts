import { Component, OnInit } from '@angular/core';
import { Invoice } from 'src/app/common/invoice';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';


@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  shoppingCart: ShoppingCart = {
    productId: 0,
    productQuantity: 0,
    invoiceId: 0
  };
  submitted = false;

  constructor(private shoppingCartService: ShoppingCartService) { }

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
}
