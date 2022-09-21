import { Component, OnInit, Inject } from '@angular/core';
import { OktaAuthStateService, OKTA_AUTH } from '@okta/okta-angular';
import { AuthState, OktaAuth } from '@okta/okta-auth-js';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  constructor( @Inject(OKTA_AUTH) private _oktaAuth: OktaAuth, ) { }

  ngOnInit(): void {
  }

  public async signOut(): Promise<void> {
    await this._oktaAuth.signOut();
  }


}
