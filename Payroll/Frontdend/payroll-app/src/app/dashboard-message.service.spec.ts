import { TestBed } from '@angular/core/testing';

import { DashboardMessageService } from './dashboard-message.service';

describe('DashboardMessageService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DashboardMessageService = TestBed.get(DashboardMessageService);
    expect(service).toBeTruthy();
  });
});
