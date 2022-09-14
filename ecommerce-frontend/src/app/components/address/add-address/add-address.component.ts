import { Component, Input, OnInit } from '@angular/core';
import { Address } from 'src/app/common/address';
import { AddressService } from 'src/app/services/address.service';

@Component({
  selector: 'app-add-address',
  templateUrl: './add-address.component.html',
  styleUrls: ['./add-address.component.css']
})
export class AddAddressComponent implements OnInit {

  @Input() currentAddress: Address = {
    id: 0,
    street: '',
    secondary: '',
    city: '',
    state: '',
    country: '',
    zip: '',
  }
  submitted = false;

  message = '';

  constructor(
    private addressservice: AddressService,
  ) { }

  ngOnInit(): void {
  }

  onEdit(item: any, field: string) {
    debugger;
    item.editFieldName = field;
  }
  close(item: any) {
    item.editFieldName = '';
  }

  //Create Address
  CreateAddressDetails(): void {
    this.message = '';
    const data = {
      street: this.currentAddress.street,
      secondary: this.currentAddress.secondary,
      city: this.currentAddress.city,
      state: this.currentAddress.state,
      country: this.currentAddress.country,
      zipCode: this.currentAddress.zip
    }
    this.addressservice.add(data)
      .subscribe({
        next: (res) => {
          console.log(res);
        },
        error: (e) => console.error(e)
      });
  }

}
