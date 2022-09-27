import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TestimonyCreateDto } from '../common/testimony/testimony-create-dto';
import { TestimonyUpdateDto } from '../common/testimony/testimony-update-dto';

const baseUrl = 'https://fruitilicious-backend.azurewebsites.net';

@Injectable({
  providedIn: 'root'
})
export class TestimonyService {

  constructor(private http: HttpClient) { }

  newTestimony(dto: TestimonyCreateDto) {
    return this.http.post(`${baseUrl}/testimony/create`, dto);
  }

  getTestimony(id: number) {
    return this.http.get(`${baseUrl}/testimony/get/${id}`);
  }

  deleteTestimony(id: number) {
    return this.http.delete(`${baseUrl}/testimony/get/${id}`);
  }

  updateTestimonyContent(dto: TestimonyUpdateDto) {
    return this.http.post(`${baseUrl}/testimony/update`, dto)
  }

  getTestimonyAll(){
    return this.http.get(`${baseUrl}/testimony/get/all`);
  }
}
