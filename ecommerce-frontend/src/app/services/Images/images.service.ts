import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImagesService {

  constructor() { }

  getAll():String[] {
    return [
      '/assets/images/Images/farmbackgroundv2.jpg'
    
    ]
  }
}
