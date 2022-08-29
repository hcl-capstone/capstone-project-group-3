import { Component, OnInit } from '@angular/core';
import { ImagesService } from '../services/Images/images.service';
//import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  images:String[] = [];
  constructor(private imageService:ImagesService) { } // private route:ActivatedRoute 

  ngOnInit(): void {
    /* this.route.params.subscribe(params => {
       if(params.searchTerm)
       this.images = this.imageService.getAll().filter(images =>images.name.toLowerCase().includes.params.searchTerm.toLowerCase());
     }) */

    this.images = this.imageService.getAll();
  }

}
