import { TestBed } from '@angular/core/testing';

import { BanuserService } from './banuser.service';

describe('BanuserService', () => {
  let service: BanuserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BanuserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
