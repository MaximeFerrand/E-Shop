import { TestBed } from '@angular/core/testing';

import { SupplierGuardService } from './supplier-guard.service';

describe('SupplierGuardService', () => {
  let service: SupplierGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SupplierGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
