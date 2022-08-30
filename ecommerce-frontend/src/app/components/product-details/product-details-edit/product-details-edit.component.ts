import { Component, Input, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductCategory } from 'src/app/common/product-category';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-details-edit',
  templateUrl: './product-details-edit.component.html',
  styleUrls: ['./product-details-edit.component.css']
})
export class ProductDetailsEditComponent implements OnInit {

  @Input() currentProduct: Product = {
    productId: 0,
    productName: '',
    stockCount: 0,
    dateLastUpdated: new Date(),
    unitPrice: 0,
    image_url: '',
    category: new ProductCategory
  }
  submitted = false;
  message = ' ';

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }

  onEdit(item: any, field: string){
    debugger;
    item.editFieldName = field;
  }
  close(item: any) {
    item.editFieldName = '';
  }

  updateProductDetails(): void {
    
    const data = {
      productId: this.currentProduct.productId,
      productName: this.currentProduct.productName,
      stockCount: this.currentProduct.stockCount,
      dateLastUpdated: Date.now,
      unitPrice: this.currentProduct.unitPrice,
      image_url: this.currentProduct.image_url,
      category: this.currentProduct.category
    }

    this.productService.update(this.currentProduct.productId, this.currentProduct)
    .subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => console.error(e) 
    })
  }

  newProduct(): void{
     this.submitted = false;
     this.currentProduct = {
      productId: 0,
      productName: '',
      stockCount: 0,
      dateLastUpdated: new Date(),
      unitPrice: 0,
      image_url: '',
      category: new ProductCategory

     }
  }
}
