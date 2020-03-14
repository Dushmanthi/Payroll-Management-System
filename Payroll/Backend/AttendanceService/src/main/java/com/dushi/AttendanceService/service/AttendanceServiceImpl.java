package com.dushi.AttendanceService.service;

import com.dushi.AttendanceService.model.Attendance;
import com.dushi.AttendanceService.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;


    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }


    @Override
    public List<Attendance> findByEmpId(Integer empId) {
        return attendanceRepository.findAllByEmpId(empId);
    }

    @Override
    public Attendance update(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }
}
