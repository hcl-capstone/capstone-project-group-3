import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { RoleService } from './role.service';

xdescribe('RoleService', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule ],
      
      declarations: [
        RoleService
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(RoleService);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'ecommerce-frontend'`, () => {
    const fixture = TestBed.createComponent(RoleService);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('ecommerce-frontend');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(RoleService);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain('ecommerce-frontend app is running!');
  });
});
