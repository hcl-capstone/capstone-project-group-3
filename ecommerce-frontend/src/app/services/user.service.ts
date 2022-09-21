import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../common/user';

const baseUrl = "https://fruitilicious-backend.azurewebsites.net/user"
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) {
  }

  update (id: any, data: any): Observable<any> {

    return this.http.post(`https://fruitilicious-backend.azurewebsites.net/user/update/${id}`, data);
  }

  getByEmail(email: string): Observable<User> {
    return this.http.get(`https://fruitilicious-backend.azurewebsites.net/user/get/${email}`); 
  }

}

