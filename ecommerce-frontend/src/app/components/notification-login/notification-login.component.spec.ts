import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotificationLoginComponent } from './notification-login.component';

xdescribe('NotificationLoginComponent', () => {
  let component: NotificationLoginComponent;
  let fixture: ComponentFixture<NotificationLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotificationLoginComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NotificationLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
