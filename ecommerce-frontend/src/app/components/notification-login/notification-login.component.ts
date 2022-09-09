import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/common/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-notification-login',
  templateUrl: './notification-login.component.html',
  styleUrls: ['./notification-login.component.css']
})
export class NotificationLoginComponent implements OnInit {

  //user: User[];

  constructor(private userService:UserService, private toastr: ToastrService, private router:Router) {
    //this.user = [];

   }

  ngOnInit(): void {
  }

  onRegister(){
    this.toastr.success("Your accout has been created!\nPlease Login.");
    //add code to route to login
  }
}