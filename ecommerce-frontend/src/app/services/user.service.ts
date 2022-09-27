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



  getByIdToken(IdToken: any): Observable<any> {
    return this.http.get(`https://fruitilicious-backend.azurewebsites.net/users/getIdToken/${IdToken}`);
  }

  register(user: any): Observable<User> {
    console.log(user);
    return this.http.post<User>(`https://fruitilicious-backend.azurewebsites.net/user/registration`, user);
  }
  
  assignUserAddress(user_id: any, address: any): Observable<User>{
    return this.http.post<User>(`https://fruitilicious-backend.azurewebsites.net/user/address/set/${user_id}`, address);
  }

  getAllUsers() : Observable<User[]> {
    return this.http.get<User[]>(`https://fruitilicious-backend.azurewebsites.net/user/all`);
  }

  getUserByName(name :  String) : Observable<User[]>{
    return this.http.get<User[]>(`https://fruitilicious-backend.azurewebsites.net/user/get/name/${name}`);
  }

  getUserByIdNumber( id : number) : Observable<User>{
    return this.http.get(`https://fruitilicious-backend.azurewebsites.net/user/get/${id}`);
  }

}
