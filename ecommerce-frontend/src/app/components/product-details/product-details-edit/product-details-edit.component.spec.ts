import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductDetailsEditComponent } from './product-details-edit.component';

xdescribe('ProductDetailsEditComponent', () => {
  let component: ProductDetailsEditComponent;
  let fixture: ComponentFixture<ProductDetailsEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
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
