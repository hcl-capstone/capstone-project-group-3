import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];

  constructor(private productService:ProductService) { 
    this.products = [];
  }

  ngOnInit(): void {
    this.productService.getProductList().subscribe(data => {
      this.products = data;
    });
    console.log('Hello World');
    for (let i = 0; i < this.products.length; i++) {
      console.log(this.products[i].productName);
    }

  }

}
