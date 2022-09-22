import { Component, Inject, OnInit } from '@angular/core';
import { OktaAuth } from '@okta/okta-auth-js';
import { OKTA_AUTH } from '@okta/okta-angular';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/common/user';
import { Observable } from 'rxjs';
import { Role } from 'src/app/common/role';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  claims!: { name: string; value: unknown }[];
  userName?: string;
  isAuthenticated!: boolean;
  userPresent: boolean;
  email?: string;
  sub: string;
  user: User = {};
  role?: Role;
  roles?: Role[];
  home: string;
  firstName: any;
  lastName?: any;


  constructor(@Inject(OKTA_AUTH) public oktaAuth: OktaAuth, public userService: UserService, private router: Router) {
  }

  async ngOnInit() {
    const idToken = await this.oktaAuth.tokenManager.get('idToken');
    this.claims = Object.entries(idToken.claims).map(entry => ({ name: entry[0], value: entry[1] }));

    this.isAuthenticated = await this.oktaAuth.isAuthenticated();
    if (this.isAuthenticated) {
      const userClaims = await this.oktaAuth.getUser();
      this.userName = userClaims.name;
      this.email = userClaims.email;
      this.sub = userClaims.sub;
      const nameArray = this.userName?.split(" ");
      if (nameArray != null) {
        this.firstName = nameArray[0];
        this.lastName = nameArray[1];
      }
      console.log(this.firstName);
    }

    this.getidToken();
    console.log(this.userPresent);
    if (this.userPresent == false) {
      this.register();
    }

  }


  goHome(): void {

    console.log(this.role?.roleName);
    if (this.role?.roleName == "Admin") {
      this.home = 'admin/home';
    }
    else{
      this.home = "";
    }



    console.log(this.home)
    this.router.navigateByUrl(this.home);
  }

  register(): void {
    this.user.firstName = this.firstName;
    this.user.lastName = this.lastName;
    this.user.email = this.email;
    this.user.idToken = this.sub;
    this.user.username = "test";
    this.user.password = "test";
    console.log(this.user);
    this.userService.register(this.user)
      .subscribe({
        next: (data: any) => {
          console.log(data);
        },
        error: (e: any) => console.error(e)
      });

  }


  getidToken(): void {
    console.log("idtoken");
    this.userService.getByIdToken(this.sub)
      .subscribe({
        next: (data) => {
          if (data) {
            this.user = data;
            if (this.user.roles != null) {
              this.roles = this.user.roles;
              this.role = this.roles[0];
              this.userPresent = true;
            }
            console.log(this.user)
          } else {
            this.userPresent = false;
            this.register();
          }
          this.goHome(); 
          return this.userPresent;

        },
        error: (e) => console.error(e)
      })
  }

}


