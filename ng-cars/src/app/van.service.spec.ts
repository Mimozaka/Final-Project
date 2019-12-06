import { TestBed } from '@angular/core/testing';

import { VanService } from './van.service';

describe('VanService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VanService = TestBed.get(VanService);
    expect(service).toBeTruthy();
  });
});
