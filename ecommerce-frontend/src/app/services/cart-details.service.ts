import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderStatus } from '../common/order-status';
import { Observable } from 'rxjs';
import { Invoice } from '../common/invoice';
import { ShoppingCart } from '../common/shopping-cart';
import { CartDetails } from '../common/cart-details';



//const baseUrl = 'http://localhost:8082/user/invoice/get';
const baseUrl = 'http://localhost:8082/invoice/cart/get';


@Injectable({
  providedIn: 'root'
})
export class CartDetailsService {

  constructor(private http: HttpClient) { }

  getCarts(id: any): Observable<CartDetails[]> {
    return this.http.get<CartDetails[]>(`${baseUrl}/${id}`);
  }
}