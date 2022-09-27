import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { ProductDetailsEditComponent } from './product-details-edit.component';

describe('ProductDetailsEditComponent', () => {
  let component: ProductDetailsEditComponent;
  let fixture: ComponentFixture<ProductDetailsEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule ],
      declarations: [ ProductDetailsEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductDetailsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
