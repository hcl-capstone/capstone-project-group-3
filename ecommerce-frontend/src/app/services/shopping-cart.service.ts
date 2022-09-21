import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ShoppingCart } from '../common/shopping-cart';
import { Observable } from 'rxjs';

const baseUrl = 'https://fruitilicious-backend.azurewebsites.net/invoice/product/add';

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {
  

  constructor(private http: HttpClient) { }

  addToCart(id: any, data: any): Observable<any> {
    return this.http.post(`${baseUrl}/${id}`, data);
  }

 
}
