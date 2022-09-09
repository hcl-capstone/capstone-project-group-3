import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';
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

  constructor(private productService: ProductService) {
    this.products = [];
  }

  ngOnInit(): void {
<<<<<<< HEAD
  }

=======
    
  }
  
>>>>>>> main
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

}