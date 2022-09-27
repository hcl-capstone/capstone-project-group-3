import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Address } from '../common/address';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  constructor(private http:HttpClient) { }


  getaddressById(address_id: any): Observable<Address> {
    return this.http.get<Address>(`http://localhost:8082/address/get/${address_id}`); 
  }

  createAddress(address: any): Observable<Address>{
    return this.http.post<Address>(`http://localhost:8082/address/create`, address);
  }

  updateAddress(address_id: any, address: any): Observable<Address>{
    return this.http.post<Address>(`http://localhost:8082/address/update/${address_id}`, address);
  }
}
