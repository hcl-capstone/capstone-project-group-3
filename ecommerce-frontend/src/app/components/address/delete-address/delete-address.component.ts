import { Component, Input, OnInit } from '@angular/core';
import { Address } from 'src/app/common/address';
import { AddressService } from 'src/app/services/address.service';

@Component({
  selector: 'app-delete-address',
  templateUrl: './delete-address.component.html',
  styleUrls: ['./delete-address.component.css']
})
export class DeleteAddressComponent implements OnInit {

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

  //Delete Address
  deleteAddressDetails(): void {
    this.addressservice.delete(this.currentAddress.id)
      .subscribe({
        next: (res) => {
          console.log(res);
        },
        error: (e) => console.error(e)
      });
  }
}
