import { TestBed } from '@angular/core/testing';

import { AddAttendanceService } from './add-attendance.service';

describe('AddAttendanceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddAttendanceService = TestBed.get(AddAttendanceService);
    expect(service).toBeTruthy();
  });
});
