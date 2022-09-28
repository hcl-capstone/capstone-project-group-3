import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { AdminProductDetailsComponent } from './admin-product-details.component';

describe('AdminProductDetailsComponent', () => {
  let component: AdminProductDetailsComponent;
  let fixture: ComponentFixture<AdminProductDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule ],
      declarations: [ AdminProductDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminProductDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
