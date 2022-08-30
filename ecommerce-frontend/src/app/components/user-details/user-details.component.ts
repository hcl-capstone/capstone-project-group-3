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

    this.userservice.update(this.currentUser.id, this.currentUser)
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
      firstName: '',
      lastName: '',
      email: ''
    }
    
  }

}
