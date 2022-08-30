import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductDetailsAddComponent } from './product-details-add.component';

describe('ProductDetailsAddComponent', () => {
  let component: ProductDetailsAddComponent;
  let fixture: ComponentFixture<ProductDetailsAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
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
