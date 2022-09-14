import { Component, Input, OnInit } from '@angular/core';
import { Address } from 'src/app/common/address';
import { AddressService } from 'src/app/services/address.service';

@Component({
  selector: 'app-update-address',
  templateUrl: './update-address.component.html',
  styleUrls: ['./update-address.component.css']
})
export class UpdateAddressComponent implements OnInit {
  @Input() currentAddress: Address = {
    id: 0,
    street: '',
    secondary: '',
    city: '',
    state: '',
    country: '',
    zip: ''
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

  //Update Addresses
  updateAddressDetails(): void {
    this.message = '';
    const data = {
      id: this.currentAddress.id,
      street: this.currentAddress.street,
      secondary: this.currentAddress.secondary,
      city: this.currentAddress.city,
      state: this.currentAddress.state,
      country: this.currentAddress.country,
      zip: this.currentAddress.zip
    }
    this.addressservice.update(this.currentAddress.id, data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted=true;
          this.message = res.message ? res.message : 'The address was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

}
