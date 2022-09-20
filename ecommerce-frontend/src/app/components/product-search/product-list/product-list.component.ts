import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';
import { ShoppingCart } from 'src/app/common/shopping-cart';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  shoppingCart: ShoppingCart = {
    productId: 0,
    productQuantity: 1,
    invoiceId: 1
  };

  constructor(private shoppingCartService: ShoppingCartService, private productService:ProductService) { }

  ngOnInit(): void {
    this.productService.getProductList().subscribe(data => {
      this.products = data;
    });
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
        },
        error: (e: any) => console.error(e)
      });
  }
}
