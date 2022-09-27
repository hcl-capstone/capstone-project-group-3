import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddressService } from './address.service';

xdescribe('AddressService', () => {
  let component: AddressService;
  let fixture: ComponentFixture<AddressService>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddressService ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddressService);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
