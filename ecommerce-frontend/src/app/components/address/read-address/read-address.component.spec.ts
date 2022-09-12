import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadAddressComponent } from './read-address.component';

describe('ReadAddressComponent', () => {
  let component: ReadAddressComponent;
  let fixture: ComponentFixture<ReadAddressComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReadAddressComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReadAddressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
