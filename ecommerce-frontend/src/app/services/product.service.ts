import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../common/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productUrl: string;
  constructor(private http:HttpClient) {
    this.productUrl = 'http://localhost:8082/product/all';
  }

  getProductList(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productUrl);
  }
}
