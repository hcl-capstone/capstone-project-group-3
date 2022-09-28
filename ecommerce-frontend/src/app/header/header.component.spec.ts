import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderComponent } from './header.component';

import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { OktaAuthStateService, OKTA_AUTH } from '@okta/okta-angular';

xdescribe('HeaderComponent', () => {
  let component: HeaderComponent;
  let fixture: ComponentFixture<HeaderComponent>;
  const authStateSpy = jasmine.createSpyObj('OktaAuthStateService', [], {
    authState$: of({
      isAuthenticated: false
    })
  });
  const authSpy = jasmine.createSpyObj('OktaAuth', ['login']);

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterTestingModule
      ],


      declarations: [ HeaderComponent ],
      providers: [
        { provide: OktaAuthStateService, useValue: authStateSpy },
        { provide: OKTA_AUTH, useValue: authSpy }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should create the app', () => {
    const fixture = TestBed.createComponent(HeaderComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'okta-angular-quickstart'`, () => {
    const fixture = TestBed.createComponent(HeaderComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('okta-angular-quickstart');
  });
});
