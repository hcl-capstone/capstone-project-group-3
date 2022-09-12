import { Component, Input, OnInit } from '@angular/core';
import { Address } from 'src/app/common/address';
import { AddressService } from 'src/app/services/address.service';

@Component({
  selector: 'app-read-address',
  templateUrl: './read-address.component.html',
  styleUrls: ['./read-address.component.css']
})
export class ReadAddressComponent implements OnInit {

  @Input() currentAddress: Address = {
    id: 0,
    street: '',
    secondary: '',
    city: '',
    state: '',
    country: '',
    zipCode: '',
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

  //Read Addresses
  readAddressDetails(): void {
    this.addressservice.findByAddressId(this.currentAddress.id)
  }
}
