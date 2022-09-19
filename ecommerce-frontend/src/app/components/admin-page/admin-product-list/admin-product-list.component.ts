import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-admin-product-list',
  templateUrl: './admin-product-list.component.html',
  styleUrls: ['./admin-product-list.component.css']
})
export class AdminProductListComponent implements OnInit {

  products: Product[] = [];
  currentProduct: Product = {};
  currentIndex = -1;
  title = '';

  constructor(private productService : ProductService) { }

  ngOnInit(): void {
    this.retrieveProducts();
  }

  retrieveProducts(): void {
    console.log("Getting List of Products");
    this.productService.getProductList()
      .subscribe({
        next: (data) => {
          this.products = data;
          console.log(data);
        }
      })
  }

  setActiveProduct(product: Product, index: number): void {
    this.currentProduct = product;
    this.currentIndex = index;
    console.log(index);
  }

  searchTitle(): void {
    this.currentIndex = -1;
    this.currentProduct = {};
    console.log(this.title);
    this.productService.findByProductName(this.title)
    .subscribe({
      next: (data) => {
        this.products = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

}
