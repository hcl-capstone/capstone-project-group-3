import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { NotificationCheckoutComponent } from './notification-checkout.component';

xdescribe('NotificationCheckoutComponent', () => {
  let component: NotificationCheckoutComponent;
  let fixture: ComponentFixture<NotificationCheckoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule ],
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
