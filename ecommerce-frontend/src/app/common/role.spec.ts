import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { Role } from './role';

xdescribe('Role', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        Role
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(Role);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'ecommerce-frontend'`, () => {
    const fixture = TestBed.createComponent(Role);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('ecommerce-frontend');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(Role);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain('ecommerce-frontend app is running!');
  });
});
