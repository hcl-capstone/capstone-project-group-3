import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  id?: number;
  product!: Product;

  constructor(private productService:ProductService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    var x = this.route.snapshot.paramMap.get('id');
    if(x != null){
      var y = +x;
      this.id = y;

      this.productService.findByProductId(this.id).subscribe(data => {
        this.product = data;
      });
    }
    else{
      this.productService.findByProductId(1).subscribe(data => {
        this.product = data;
      });
    }

    
  }

  get productName() { return (this.product && this.product.productName) ? this.product.productName : null}
  get productPrice() { return (this.product && this.product.unitPrice) ? this.product.unitPrice : null}
  get productUrl() { 
    return (this.product && this.product.image_url) ? 
      this.product.image_url : 
      null}

}
