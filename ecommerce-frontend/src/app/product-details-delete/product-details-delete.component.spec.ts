import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { ProductDetailsDeleteComponent } from './product-details-delete.component';

describe('ProductDetailsDeleteComponent', () => {
  let component: ProductDetailsDeleteComponent;
  let fixture: ComponentFixture<ProductDetailsDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule ],
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
