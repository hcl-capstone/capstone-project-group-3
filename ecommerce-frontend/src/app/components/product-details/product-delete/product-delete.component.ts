import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.html',
  styleUrls: ['./product-delete.css']
})
export class ProductDeleteComponent implements OnInit {

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