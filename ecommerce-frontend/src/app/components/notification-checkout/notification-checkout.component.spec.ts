import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotificationCheckoutComponent } from './notification-checkout.component';

describe('NotificationCheckoutComponent', () => {
  let component: NotificationCheckoutComponent;
  let fixture: ComponentFixture<NotificationCheckoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotificationCheckoutComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NotificationCheckoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
