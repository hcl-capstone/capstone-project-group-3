import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { ProductDetailsAddComponent } from './product-details-add.component';

xdescribe('ProductDetailsAddComponent', () => {
  let component: ProductDetailsAddComponent;
  let fixture: ComponentFixture<ProductDetailsAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule ],
      declarations: [ ProductDetailsAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductDetailsAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
