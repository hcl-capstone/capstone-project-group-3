import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductDTO } from 'src/app/common/productdto';
import { ProductService } from 'src/app/services/product.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-admin-product-details',
  templateUrl: './admin-product-details.component.html',
  styleUrls: ['./admin-product-details.component.css']
})
export class AdminProductDetailsComponent implements OnInit {

  @Input() viewMode = false;

  @Input() currentProduct: Product = {
    productName: '',
    image_url: '',
    unitPrice: 0,
    stockCount: 0,
  }

  productURL? = '';

  productDTO : ProductDTO = {};

  message = '';

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient ) { }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getProduct(this.route.snapshot.params["id"]);
      console.log(`details: ${this.route.snapshot.params["id"]}`);
    }
  }

  getProduct(id: number): void {
    this.productService.findByProductId(id).subscribe({
      next: (data) =>{
        this.currentProduct = data;
        this.productURL = this.currentProduct.image_url;
        console.log(data);
      },
      error: (e) => console.error(e)
    })
  }

  updateProduct(): void {
    console.log("Updating Product");
    console.log(this.currentProduct);
    this.message = '';
    
    this.productDTO.productName=this.currentProduct.productName;
    this.productDTO.stockCount=this.currentProduct.stockCount;
    this.productDTO.unitPrice=this.currentProduct.unitPrice;
    this.productDTO.image_url=this.currentProduct.image_url;
    this.productDTO.category=this.currentProduct.category?.categoryId;

    this.productService.update(this.currentProduct.productId, this.productDTO)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'This product was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  deleteProduct(): void {
    console.log("Deleting Product");
    console.log(this.currentProduct);
    this.productService.delete(this.currentProduct.productId)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/admin/product-list']);
        },
        error: (e) => console.error(e)
      });
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
        this.currentProduct.image_url=data.url;
      }
    );
  }

}
