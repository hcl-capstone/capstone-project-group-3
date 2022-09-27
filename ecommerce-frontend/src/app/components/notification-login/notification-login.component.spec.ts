import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { NotificationLoginComponent } from './notification-login.component';

xdescribe('NotificationLoginComponent', () => {
  let component: NotificationLoginComponent;
  let fixture: ComponentFixture<NotificationLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule ],
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
