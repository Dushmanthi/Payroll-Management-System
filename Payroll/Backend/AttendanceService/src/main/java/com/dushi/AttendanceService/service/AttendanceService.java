package com.dushi.AttendanceService.service;

import com.dushi.AttendanceService.model.Attendance;

import java.util.List;

public interface AttendanceService {
    Attendance saveAttendance(Attendance attendance);

    List<Attendance> findByEmpId(Integer empId);

    Attendance update(Attendance attendance);
}
