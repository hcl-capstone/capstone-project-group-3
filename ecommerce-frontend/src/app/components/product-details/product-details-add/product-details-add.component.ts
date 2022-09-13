import { HttpClient } from '@angular/common/http';
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
  
  constructor(private productService: ProductService, private http: HttpClient) { }

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

  selectedFile = '';
  onFileSelected(event: any){
    this.selectedFile = event.target.files[0];
    //console.log(event);
  }

  onUpload(){
    const fd = new FormData();
    fd.append('file', this.selectedFile);
    fd.append('upload_preset', "nz2scxg7")
    this.http.post('https://api.cloudinary.com/v1_1/du6vcjz7b/auto/upload', fd).subscribe(
      (data: any) => {
        console.log(data, data.url);
        this.product.image_url=data.url;
      }
    );
  }

}