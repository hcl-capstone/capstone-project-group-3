import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../common/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productUrl: string;
  private productAddUrl: string;
  constructor(private http:HttpClient) {
    this.productUrl = 'http://localhost:8082/product/all';
    this.productAddUrl = 'http://localhost:8082/product/add';
  }

  getProductList(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productUrl);
  }

  findByProductName(productName: any): Observable<Product[]>  {
    return this.http.get<Product[]>(`http://localhost:8082/product/get/byName?name=${productName}`);
  }

  add(data: any): Observable<Product> {
    return this.http.post<Product>('http://localhost:8082/product/add', data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put('http://localhost:8082/product/update/${id}', data)
  }
}
