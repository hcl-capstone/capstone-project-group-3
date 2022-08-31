import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductCategory } from 'src/app/common/product-category';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-details-add',
  templateUrl: './product-details-add.component.html',
  styleUrls: ['./product-details-add.component.css']
})
export class ProductDetailsAddComponent implements OnInit {

  product: Product = {
    productId: 0,
    productName: '',
    stockCount: 0,
    dateCreated: new Date(),
    dateLastUpdated: new Date(),
    unitPrice: 0,
    image_url: '',
    category: new ProductCategory
  };
  submitted = false;
  
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }

  saveProduct(): void {
    const data = {
      productId: this.product.productId,
      productName: this.product.productName,
      stockCount: this.product.stockCount,
      dateCreated: Date.now,
      unitPrice: this.product.unitPrice,
      image_url: this.product.image_url,
      category: this.product.category
    };

    this.productService.add(data)
    .subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => console.error(e)
    });
}
  
newProduct(): void {
  this.submitted = false;
  this.product = {
    productId: 0,
    productName: '',
    stockCount: 0,
    dateCreated: new Date(),
    unitPrice: 0,
    image_url: '',
    category: new ProductCategory
  };
}

}