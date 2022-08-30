import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Invoice } from '../common/invoice';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class InvoiceService {



  constructor(private http:HttpClient) {
    
   }

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

}
