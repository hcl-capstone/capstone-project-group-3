import { Component, Input, OnInit } from '@angular/core';
import { User } from 'src/app/common/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  @Input() currentUser: User ={
    id: 0,
    firstName: '',
    lastName: '',
    email: '',
  } 
  submitted = false;
  message = '';

  constructor(
    private userservice: UserService,
    ) { }

  ngOnInit(): void {

  }
  onEdit(item: any, field: string){
    debugger;
    item.editFieldName = field;
  }
  close(item: any){
    item.editFieldName = '';
  }

  updateUserDetails(): void {
    this.message = '';
    const data = {
      id: this.currentUser.id,
      firstName: this.currentUser.firstName,
      lastName: this.currentUser.lastName,
      email:this.currentUser.email
    }

    this.userservice.update(this.currentUser.id, data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted=true;
          this.message = res.message ? res.message : 'The user was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  newUser(): void{
    this.submitted = false;
    this.currentUser = {
      id: 0,
      firstName: '',
      lastName: '',
      email: ''
    }
  }


  getUserByEmail(email: string): User {
    this.userservice.getByEmail(email)
      .subscribe({
        next: (data) => {
          this.currentUser = data; 
          console.log(this.currentUser);
        },
        error: (e) => console.error(e)
      })
      return this.currentUser;
  }
}