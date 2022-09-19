import { Component, Inject, OnInit } from '@angular/core';
import { OktaAuth } from '@okta/okta-auth-js';
import { OKTA_AUTH } from '@okta/okta-angular';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/common/user';
import { Observable } from 'rxjs';

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

  constructor(@Inject(OKTA_AUTH) public oktaAuth: OktaAuth, public userService: UserService) {
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
        console.log(this.user); 
      },
      error: (e) => console.error(e)
    })
  }

}


