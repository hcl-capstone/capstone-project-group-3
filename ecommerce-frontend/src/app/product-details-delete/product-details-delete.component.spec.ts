import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ProductDetailsDeleteComponent } from './product-details-delete.component';

xdescribe('ProductDetailsDeleteComponent', () => {
  let component: ProductDetailsDeleteComponent;
  let fixture: ComponentFixture<ProductDetailsDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductDetailsDeleteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductDetailsDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
