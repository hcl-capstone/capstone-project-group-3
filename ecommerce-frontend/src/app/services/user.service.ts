import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../common/user';

const baseUrl = "http://localhost:8082/user"
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) {
  }

  update (id: any, data: any): Observable<any> {

    return this.http.post(`http://localhost:8082/user/update/${id}`, data);
  }

  getByEmail(email: string): Observable<User> {
    return this.http.get(`http://localhost:8082/user/get/${email}`); 
  }

}

