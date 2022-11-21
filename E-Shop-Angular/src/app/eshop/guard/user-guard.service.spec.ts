import { TestBed } from '@angular/core/testing';

import { UserGuardService } from './user-guard.service';

describe('ClientGuardService', () => {
  let service: UserGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
