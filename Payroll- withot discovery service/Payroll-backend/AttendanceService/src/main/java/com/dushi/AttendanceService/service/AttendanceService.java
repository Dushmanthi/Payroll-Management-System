package com.dushi.AttendanceService.service;

import com.dushi.AttendanceService.model.Attendance;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AttendanceService {
    Attendance saveAttendance(Attendance attendance);

    Attendance update(Attendance attendanceDetails,Integer id);

    List<Attendance> findAllAttendance();

    Object findMonthlyAttendance(Integer empId, Integer year, String month);

    List<Attendance> findEmp(Integer empId);

    Optional<Attendance> findAttendance(Integer id);

   Map<String, Boolean> deleteAttendance(Integer id);
}
