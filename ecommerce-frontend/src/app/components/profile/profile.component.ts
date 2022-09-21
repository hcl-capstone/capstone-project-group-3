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
  email?: string;
  sub: string; 
  user?: User; 
  role?: Role;
  roles?: Role[]; 
  home: string; 


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
    }
  
    this.userService.getByIdToken(this.sub)
      .subscribe({
        next: (data) => {
        this.user = data;
        this.roles = this.user.roles; 
        if(this.roles != null){
          this.role = this.roles[0];  
        }
        console.log(this.user, this.role); 
      },
      error: (e) => console.error(e)
    })

  }


  goHome(): void {

    console.log(this.role?.roleName); 
    if(this.role?.roleName == "Admin"){
      this.home = 'admin/home'; 
    }
    if(this.role?.roleName == "User"){
      this.home = "";
    }



    console.log(this.home)
    this.router.navigateByUrl(this.home);
  }

}


