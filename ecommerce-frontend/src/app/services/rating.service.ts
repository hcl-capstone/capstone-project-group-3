import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Rating } from '../common/rating/rating';
import { RatingCreateDto } from '../common/rating/rating-create-dto';
import { RatingUpdateDto } from '../common/rating/rating-update-dto';
import { Observable } from 'rxjs';
import { RatingDeleteDto } from '../common/rating/rating-delete-dto';

const baseUrl = 'https://fruitilicious-backend.azurewebsites.net/product';

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  constructor(private http: HttpClient) { }

  newRating(dto: RatingCreateDto): Observable<Rating> {
    return this.http.post<Rating>(`${baseUrl}/ratings/add`, dto);
  }

  getRating(id: number): Observable<Rating> {
    return this.http.get(`${baseUrl}/ratings/${id}`);
  }

  // deleteRating(deleteDto:RatingDeleteDto): Observable<Rating> {
  //   return this.http.delete<Rating>(`${baseUrl}/ratings/delete`, deleteDto);
  // }

  updateRatingContent(dto: RatingUpdateDto): Observable<Rating> {
    return this.http.post<Rating>(`${baseUrl}/ratings/update`, dto)
  }

  getRatingAll(): Observable<Rating[]>{
    console.log(`${baseUrl}/rating/get/all`);
    return this.http.get<Rating[]>(`${baseUrl}/ratings/get/all`);
  }
}
