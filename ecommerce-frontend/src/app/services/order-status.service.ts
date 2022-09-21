import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderStatus } from '../common/order-status';
import { Observable } from 'rxjs';
import { Invoice } from '../common/invoice';
import { ShoppingCart } from '../common/shopping-cart';


const baseUrl = 'https://fruitilicious-backend.azurewebsites.net/user/invoice/get';
const cartUrl = 'https://fruitilicious-backend.azurewebsites.net/invoice/cart/get';

@Injectable({
  providedIn: 'root'
})
export class OrderStatusService {

  constructor(private http: HttpClient) { }

  getInvoices(id: any): Observable<Invoice[]> {
    return this.http.get<Invoice[]>(`${baseUrl}/${id}`);
  }

  getCarts(id: any): Observable<ShoppingCart[]> {
    return this.http.get<ShoppingCart[]>(`${cartUrl}/${id}`);
  }
}