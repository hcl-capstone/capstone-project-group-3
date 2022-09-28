import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/common/user';
import { UserUpdateDTO } from 'src/app/common/user-update-dto';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-user-details',
  templateUrl: './admin-user-details.component.html',
  styleUrls: ['./admin-user-details.component.css']
})
export class AdminUserDetailsComponent implements OnInit {

  @Input() viewMode = false;

  @Input() currentUser: User = {
    firstName : '',
    lastName : '',
    email : '',
    idToken: '',
  }

  userUpdateDTO : UserUpdateDTO = {};

  message = '';

  constructor(
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient ) { }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getUser(this.route.snapshot.params["id"]);
      console.log(`details: ${this.route.snapshot.params["id"]}`);
    }
  }

  getUser(id: number): void {
    this.userService.getUserByIdNumber(id).subscribe({
      next: (data) =>{
        this.currentUser = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    })
  }

  updateUser(): void {
    console.log("Updating User");
    console.log(this.currentUser);
    this.message = '';
    
    this.userUpdateDTO.firstName=this.currentUser.firstName;
    this.userUpdateDTO.lastName=this.currentUser.lastName;
    this.userUpdateDTO.email=this.currentUser.email;
    this.userUpdateDTO.idToken=this.currentUser.idToken;

    this.userService.update(this.currentUser.userId, this.userUpdateDTO)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'This user was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  // deleteUser(): void {
  //   console.log("Deleting User");
  //   console.log(this.currentUser);
  //   this.userService.delete(this.currentUser.userId)
  //     .subscribe({
  //       next: (res) => {
  //         console.log(res);
  //         this.router.navigate(['/admin/user-list']);
  //       },
  //       error: (e) => console.error(e)
  //     });
  // }

}
