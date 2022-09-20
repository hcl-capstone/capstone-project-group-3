import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { OrderStatusService } from 'src/app/services/order-status.service';
import { ProductService } from 'src/app/services/product.service';
import { OrderStatusComponent } from '../order-status/order-status.component';
import { Product } from 'src/app/common/product';
import { CartDetails } from 'src/app/common/cart-details';
import { CartDetailsService } from 'src/app/services/cart-details.service';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit {

  carts: CartDetails[];
  id?: number;
  prod?: Product;

  constructor(private cartDetailsService: CartDetailsService, private route: ActivatedRoute) {
  
   }

   ngOnInit(): void {
    var x = this.route.snapshot.paramMap.get('id');
    if(x != null){
      var y = +x;
      this.id = y;

      this.cartDetailsService.getCarts(this.id).subscribe((data: CartDetails[]) => {
        this.carts = data;
        console.log('these are the carts: ' + this.carts);
        console.log('2nd ');
      });
    }
    else{
      this.cartDetailsService.getCarts(1).subscribe((data: CartDetails[]) => {
        this.carts = data;
      });
    }
   }



}
