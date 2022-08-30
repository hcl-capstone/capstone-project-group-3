import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-product-details-delete',
  templateUrl: './product-details-delete.component.html',
  styleUrls: ['./product-details-delete.component.css']
})
export class ProductDetailsDeleteComponent implements OnInit {

  productId: 0 | undefined;

  submitted = false;
  
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }

  deleteProduct(): void {
    this.productService.delete(this.productId)
;
}


}