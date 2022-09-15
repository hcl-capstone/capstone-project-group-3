import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { OrderStatusService } from 'src/app/services/order-status.service';
import { ProductService } from 'src/app/services/product.service';
import { OrderStatusComponent } from '../order-status/order-status.component';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit {

  carts: ShoppingCart[];
  id?: number;
  productService: ProductService;


  constructor(private orderStatusService: OrderStatusService, private route: ActivatedRoute) {
    // this.carts;
   }

  ngOnInit(): void {
    var x = this.route.snapshot.paramMap.get('id');
    if(x != null){
      var y = +x;
      this.id = y;

      this.orderStatusService.getCarts(this.id).subscribe(data => {
        this.carts = data;
      });
    }
    else{
      this.orderStatusService.getCarts(1).subscribe(data => {
        this.carts = data;
      });
    }
  }

  // getCarts(): void {
  //   this.orderStatusService.getCarts(this.id).subscribe(data => {
  //     this.carts = data;
  //   })
  // }

}
