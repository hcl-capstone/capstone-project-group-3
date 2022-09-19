import { Component, Inject, OnInit } from '@angular/core';
import { OktaAuth } from '@okta/okta-auth-js';
import { OKTA_AUTH } from '@okta/okta-angular';

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
  sub?: string; 

  constructor(@Inject(OKTA_AUTH) public oktaAuth: OktaAuth) {
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
  
    console.log(this.sub); 
  }

}


