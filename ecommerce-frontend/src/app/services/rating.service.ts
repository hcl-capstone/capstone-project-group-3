import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Rating } from '../common/rating/rating';
import { RatingCreateDto } from '../common/rating/rating-create-dto';
import { RatingUpdateDto } from '../common/rating/rating-update-dto';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8082';

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  constructor(private http: HttpClient) { }

  newRating(dto: RatingCreateDto): Observable<Rating> {
    return this.http.post<Rating>(`${baseUrl}/rating/create`, dto);
  }

  getRating(id: number): Observable<Rating> {
    return this.http.get(`${baseUrl}/rating/get/${id}`);
  }

  deleteRating(id: number): Observable<Rating> {
    return this.http.delete(`${baseUrl}/rating/get/${id}`);
  }

  updateRatingContent(dto: RatingUpdateDto): Observable<Rating> {
    return this.http.post<Rating>(`${baseUrl}/rating/update`, dto)
  }

  getRatingAll(): Observable<Rating[]>{
    console.log(`${baseUrl}/rating/get/all`);
    return this.http.get<Rating[]>(`${baseUrl}/rating/get/all`);
  }
}
