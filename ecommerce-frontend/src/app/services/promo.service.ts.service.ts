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
    this.PromoUrl = 'https://fruitilicious-backend.azurewebsites.net/Promo/all';
    this.PromoAddUrl = 'https://fruitilicious-backend.azurewebsites.net/Promo/add';
  }

  getPromoList(): Observable<Promo[]> {
    return this.http.get<Promo[]>(this.PromoUrl);
  }

  delete(data: any): Observable<Promo> {
    console.log(`https://fruitilicious-backend.azurewebsites.net/Promo/delete/${data}`);
    return this.http.delete(`https://fruitilicious-backend.azurewebsites.net/Promo/delete/${data}`);
  }

  findByPromoName(PromoName: any): Observable<Promo>  {
    return this.http.get<Promo>(`https://fruitilicious-backend.azurewebsites.net/promo/get/${PromoName}`);
  }



}
