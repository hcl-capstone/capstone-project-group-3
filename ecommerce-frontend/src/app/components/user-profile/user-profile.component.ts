import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { Address } from 'src/app/common/address';
import { Invoice } from 'src/app/common/invoice';
import { ShoppingCart } from 'src/app/common/shopping-cart';
import { AddressService } from 'src/app/services/address.service';
import { InvoiceService } from 'src/app/services/invoice.service';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';
import { UserService } from 'src/app/services/user.service';
import { UserDetailsComponent } from '../user-details/user-details.component';
import { OktaAuth } from '@okta/okta-auth-js';
import { OKTA_AUTH } from '@okta/okta-angular';
import { User } from "src/app/common/user"; 
import { ToastrService } from 'ngx-toastr';
import { UserUpdateDTO } from 'src/app/common/user-update-dto';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  userDetails:UserDetailsComponent;


  invoices?:Invoice[];
  invoice: Invoice = {};  
  address?:Address[];  
  add:Address;
  updatedAddress: Address = {};
  carts?:ShoppingCart[];  
  id:string | undefined; 
  user:User;
  userUpdateDTO : UserUpdateDTO = {};
  email?:string; 
  claims!: { name: string; value: unknown }[];
  sub: string; 
  isAuthenticated!: boolean;
  name?: string;
  paymentHandler:any = null;

  constructor(private toastr: ToastrService, private invoiceService: InvoiceService, private addressService: AddressService , @Inject(OKTA_AUTH) public oktaAuth: OktaAuth, public userService: UserService) { 

  }

  async ngOnInit() {
    const idToken = await this.oktaAuth.tokenManager.get('idToken');
    this.claims = Object.entries(idToken.claims).map(entry => ({ name: entry[0], value: entry[1] }));

    this.isAuthenticated = await this.oktaAuth.isAuthenticated();
    if (this.isAuthenticated) {
      const userClaims = await this.oktaAuth.getUser();

      this.sub = userClaims.sub; 
    }
  
    this.userService.getByIdToken(this.sub)
    .subscribe({
      next: (data) => {
      this.user = data;
      this.email = this.user.email; 
      this.address = data.address; 
      this.invoices = data.invoices; 
      this.name = this.user.firstName; 
      if(this.user?.address != null){
        this.add = this.user?.address[0]; 
      }
      if(this.invoices != null){
        this.invoice = this.invoices[0]; 
      } 

      this.carts = this.invoice.carts; 
  
      console.log(this.user, this.address, this.name, this.add, this.invoice); 
    },
    error: (e) => console.error(e)
    })
  }

  doCheckout(): void {
    this.invoiceService.getCheckout(this.id)
      .subscribe({
        next: (data) => {
          //this.invoice = data;
          console.log(this.invoice);
        },
        error: (e) => console.error(e)


      })
  }


  getInvoice(): void {
    this.invoiceService.getInvoice(this.id)
      .subscribe({
        next: (data) => {
          this.carts = data.carts; 
          console.log(this.invoice, this.address, this.carts); 
        },
        error: (e) => console.error(e)
    })
  }

  getIdToken(): void {
    this.userService.getByIdToken(this.sub)
      .subscribe({
        next: (data) => {
        this.user = data;
        this.email = this.user.email; 
        this.address = data.address; 
        this.name = this.user.firstName; 
        console.log(this.user, this.address, this.name); 
      },
      error: (e) => console.error(e)
    })
  }

  updateUsersAddress(): void{
    console.log("Updating User's Address");
    // console.log(this.currentUser);
    // this.message = '';
    
    this.updatedAddress.street=this.add.street;
    this.updatedAddress.secondary=this.add.secondary;
    this.updatedAddress.city=this.add.city;
    this.updatedAddress.state=this.add.state;
    this.updatedAddress.country=this.add.country;
    this.updatedAddress.zip=this.add.zip;

    this.addressService.updateAddress(this.add.addressId, this.updatedAddress)
      .subscribe({
        next: (res) => {
          console.log(res);
        },
        error: (e) => console.error(e)
      });
  }

  updateUser(): void {
    console.log("Updating User");
    
    this.userUpdateDTO.firstName=this.user.firstName;
    this.userUpdateDTO.lastName=this.user.lastName;
    this.userUpdateDTO.email=this.user.email;
    this.userUpdateDTO.idToken=this.user.idToken;

    this.userService.update(this.user.userId, this.userUpdateDTO)
      .subscribe({
        next: (res) => {
          console.log(res);
          
        },
        error: (e) => console.error(e)
      });
  }

  updateProfile(): void{
    this.updateUser();
    this.updateUsersAddress();
    this.toastr.success("User Information Updated Successfully");
  }

}
