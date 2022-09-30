import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Invoice } from '../common/invoice';
import { Observable } from 'rxjs';
import { UpdateCartDto } from '../common/update-cart-dto';
import { ShoppingCart } from '../common/shopping-cart';


@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

   getCheckout(id: any): Observable<Invoice> {
    return this.http.post<Invoice>(`https://fruitilicious-backend.azurewebsites.net/invoice/checkout/${id}`, id);
   }



  private invoiceUrl: string;
  constructor(private http:HttpClient) {

    this.invoiceUrl = 'https://fruitilicious-backend.azurewebsites.net/invoice/all';

  }

  getInvoiceList(): Observable<Invoice[]> {
    return this.http.get<Invoice[]>(this.invoiceUrl);
  }

  getInvoice(id: any): Observable<Invoice> {
    return this.http.get<Invoice>(`https://fruitilicious-backend.azurewebsites.net/invoice/get/${id}`);
  }

  deleteProduct(invoice_id: any, cartId: any): Observable<Invoice> {

    return this.http.get<Invoice>(`https://fruitilicious-backend.azurewebsites.net/invoice/product/delete/${invoice_id}/${cartId}`);

  }

  postInvoiceUpdate(updateCartDto: any): Observable<ShoppingCart> {
    return this.http.post<ShoppingCart>(`https://fruitilicious-backend.azurewebsites.net/invoice/product/update`, updateCartDto);
  }

  createUserInvoice(user_id: any): Observable<Invoice> {
    return this.http.post<Invoice>(`https://fruitilicious-backend.azurewebsites.net/invoice/create/${user_id}`, user_id);
  }
}
