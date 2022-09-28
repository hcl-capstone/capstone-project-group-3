import { TestBed } from '@angular/core/testing';

import { PromoServiceTsService } from './promo.service.ts.service';

describe('PromoServiceTsService', () => {
  let service: PromoServiceTsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PromoServiceTsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
