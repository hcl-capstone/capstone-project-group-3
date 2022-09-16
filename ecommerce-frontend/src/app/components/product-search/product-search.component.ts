import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';
import { ShoppingCart } from 'src/app/common/shopping-cart';



@Component({
  selector: 'app-product-search',
  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.css']
})
export class ProductSearchComponent implements OnInit {
  products:Product[];
  currentTutorial: Product = {};
  currentIndex = -1;
  productName = '';
  shoppingCart: ShoppingCart = {
    productId: 0,
    productQuantity: 1,
    invoiceId: 1
  };


  constructor(private shoppingCartService: ShoppingCartService,private productService: ProductService) {
    this.products = [];
  }

  ngOnInit(): void {
  }

  doSearch(): void {
    this.currentTutorial = {};
    this.currentIndex = -1;

    this.productService.findByProductName(this.productName)
      .subscribe({
        next: (data) => {
          this.products = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  saveShoppingCart(): void {
    const data = {
      productQuantity: 1,
      productId: 1
      
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
