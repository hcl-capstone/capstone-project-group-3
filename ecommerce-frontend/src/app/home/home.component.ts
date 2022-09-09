import { Component, OnInit } from '@angular/core';
import { ImagesService } from '../services/Images/images.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  images:String[] = [];

  constructor(private imageService:ImagesService) { }  

  ngOnInit(): void {
    this.images = this.imageService.getAll();
  }

}
