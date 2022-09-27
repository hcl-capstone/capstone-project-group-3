import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Address } from '../common/address';

const baseUrl = "http://localhost:8082/address-controller"
@Injectable({
  providedIn: 'root'
})
export class AddressService {

  constructor(private http: HttpClient) {

  }

  add(data: any): Observable<Address> {
    return this.http.post<Address>(`http://localhost:8082/address-controller/add`, data);
  }

  findByAddressId(id: any): Observable<Address> {
    return this.http.get<Address>(`http://localhost:8082/address-controller/get/${id}`);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.post(`http://localhost:8082/address-controller/update/${id}`, data);
  }

  delete(data: any): Observable<Address> {
    return this.http.delete(`http://localhost:8082/address-controller/delete/${data}`);
  }

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
