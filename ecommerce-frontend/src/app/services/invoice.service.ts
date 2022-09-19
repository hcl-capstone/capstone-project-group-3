import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Invoice } from '../common/invoice';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

   getCheckout(id: any): Observable<Invoice> {
    return this.http.post<Invoice>(`http://localhost:8082/invoice/checkout/${id}`, id);
   }



  private invoiceUrl: string;
  constructor(private http:HttpClient) {
    this.invoiceUrl = 'http://localhost:8082/invoice/all';
  }

  getInvoiceList(): Observable<Invoice[]> {
    return this.http.get<Invoice[]>(this.invoiceUrl);
  }

  getInvoice(id: any): Observable<Invoice> {
    return this.http.get<Invoice>(`http://localhost:8082/invoice/get/${id}`);
  }

  deleteProduct(invoice_id: any, cart: any): Observable<Invoice> {
    return this.http.get<Invoice>(`http://localhost:8082/user/invoice/product/delete/${invoice_id}/${cart}`);
    
   }

}
