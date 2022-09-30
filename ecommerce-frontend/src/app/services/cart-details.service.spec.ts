import { TestBed } from '@angular/core/testing';

import { OrderStatusService } from './order-status.service';

import { CartDetailsService } from './cart-details.service';

xdescribe('CartDetailsService', () => {
  let service: CartDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CartDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
