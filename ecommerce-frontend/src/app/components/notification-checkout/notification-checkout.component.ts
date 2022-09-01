import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-notification-checkout',
  templateUrl: './notification-checkout.component.html',
  styleUrls: ['./notification-checkout.component.css']
})
export class NotificationCheckoutComponent implements OnInit {

  constructor(private toastr: ToastrService, private router:Router) { }

  ngOnInit(): void {
  }

  onCheckout(){
    this.toastr.success("Order placed successfully!\nYour order is being processed and will be shipped soon");
    //add code to route to login
  }

}
