import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/common/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-user-list',
  templateUrl: './admin-user-list.component.html',
  styleUrls: ['./admin-user-list.component.css']
})
export class AdminUserListComponent implements OnInit {

  users: User[] = [];
  currentUser: User = {};
  currentIndex = -1;
  name = '';

  constructor(private userService : UserService) { }

  ngOnInit(): void {
    this.retrieveUsers();
  }

  retrieveUsers(): void {
    console.log("Getting List of Users");
    this.userService.getAllUsers()
      .subscribe({
        next: (data) => {
          this.users = data;
          console.log(data);
        }
      })
  }

  setActiveUser(user: User, index: number): void {
    this.currentUser = user;
    this.currentIndex = index;
    console.log(index);
  }

  searchName(): void {
    this.currentIndex = -1;
    this.currentUser = {};
    console.log(this.name);
    this.userService.getUserByName(this.name)
    .subscribe({
      next: (data) => {
        this.users = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

}
