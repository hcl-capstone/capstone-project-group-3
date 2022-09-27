import { TestBed } from '@angular/core/testing';

import { TestimonyService } from './testimony.service';

describe('TestimonyService', () => {
  let service: TestimonyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TestimonyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
