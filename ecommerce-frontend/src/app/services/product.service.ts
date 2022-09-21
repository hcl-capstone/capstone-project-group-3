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
    this.productUrl = 'https://fruitilicious-backend.azurewebsites.net/product/all';
    this.productAddUrl = 'https://fruitilicious-backend.azurewebsites.net/product/add';
  }

  getProductList(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productUrl);
  }

  delete(data: any): Observable<Product> {
    console.log(`https://fruitilicious-backend.azurewebsites.net/product/delete/${data}`);
    return this.http.delete(`https://fruitilicious-backend.azurewebsites.net/product/delete/${data}`);
  }

  findByProductName(productName: any): Observable<Product[]>  {
    return this.http.get<Product[]>(`https://fruitilicious-backend.azurewebsites.net/product/get/byName?name=${productName}`);
  }


  findByProductId(productId: any): Observable<Product>{
    return this.http.get<Product>(`https://fruitilicious-backend.azurewebsites.net/product/get/${productId}`);
  }

  add(data: any): Observable<Product> {
    return this.http.post<Product>(`https://fruitilicious-backend.azurewebsites.net/product/add`, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.post(`https://fruitilicious-backend.azurewebsites.net/product/update/${id}`, data)
  }
}
