import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Product } from 'src/app/common/product';
import { RatingCreateDto } from 'src/app/common/rating/rating-create-dto';
import { ProductService } from 'src/app/services/product.service';
import { RatingService } from 'src/app/services/rating.service';

@Component({
  selector: 'app-testimony',
  templateUrl: './testimony.component.html',
  styleUrls: ['./testimony.component.css']
})
export class TestimonyComponent implements OnInit {

  products: Product[] = [];
  currentProduct: Product = {};
  currentIndex = -1;
  title = '';
  selectedProduct: number;
  ratingCreateDto: RatingCreateDto = {};
  selectedRating: number;
  selectedTestimony: string;

  constructor(private productService : ProductService, private ratingServce : RatingService, private toastr: ToastrService) { }

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

  getUserFeedBack(): void{
    alert("Thank you for your feedback!");
    this.ratingCreateDto.productId = this.selectedProduct;
    this.ratingCreateDto.name = "";
    this.ratingCreateDto.rating = this.selectedRating;
    this.ratingCreateDto.testimony = this.selectedTestimony;
   
    this.ratingServce.newRating(this.ratingCreateDto)
    .subscribe({
      next: (data: any) => {
        console.log(data);
      },
      error: (e: any) => console.error(e)
    });

    // this.productService.findByProductId(this.selectedProduct).subscribe({
    //   next: (data: any) => {
    //     console.log(data);
    //   },
    //   error: (e: any) => console.error(e)
    // });

  }

}
