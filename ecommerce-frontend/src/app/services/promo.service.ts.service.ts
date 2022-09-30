import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Promo } from '../common/promo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PromoServiceTsService {

  private PromoUrl: string;
  private PromoAddUrl: string;
  
  constructor(private http:HttpClient) {
    this.PromoUrl = 'http://localhost:8082/Promo/all';
    this.PromoAddUrl = 'http://localhost:8082/Promo/add';
  }

  getPromoList(): Observable<Promo[]> {
    return this.http.get<Promo[]>(this.PromoUrl);
  }

  delete(data: any): Observable<Promo> {
    console.log(`http://localhost:8082/Promo/delete/${data}`);
    return this.http.delete(`http://localhost:8082/Promo/delete/${data}`);
  }

  findByPromoName(PromoName: any): Observable<Promo>  {
    return this.http.get<Promo>(`http://localhost:8082/promo/get/${PromoName}`);
  }



}
