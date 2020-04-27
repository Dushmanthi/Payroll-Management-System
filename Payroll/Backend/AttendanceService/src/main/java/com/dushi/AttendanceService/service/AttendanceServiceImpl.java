package com.dushi.AttendanceService.service;

import com.dushi.AttendanceService.model.Attendance;
import com.dushi.AttendanceService.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
//import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;


    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance update(Attendance attendanceDetails,Integer id) {
        Optional<Attendance> existingAttendance = attendanceRepository.findById(id);
        System.out.println("update"+existingAttendance);
        if (existingAttendance.isPresent()) {
            Attendance attendance1 = existingAttendance.get();
            attendance1.setEmpId(attendanceDetails.getEmpId());
            attendance1.setYear(attendanceDetails.getYear());
            attendance1.setMonth(attendanceDetails.getMonth());
            attendance1.setDay(attendanceDetails.getDay());
            attendance1.setWorkingHours(attendanceDetails.getWorkingHours());
            attendance1.setIsPresent(attendanceDetails.getIsPresent());
            return attendanceRepository.save(attendance1);
        } else {
            return null;

        }
    }

    @Override
    public List<Attendance> findEmp(Integer empId) {
        System.out.println("sgdgf" + empId);
        return attendanceRepository.findByEmpId(empId);
    }

    @Override
    public Optional<Attendance> findAttendance(Integer id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public Map<String, Boolean> deleteAttendance(Integer id) {
        Optional<Attendance> attendance = attendanceRepository.findById(id);
        if (attendance.isPresent()) {
            Attendance attendance1 = attendance.get();
            attendanceRepository.deleteById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        } else {
            return null;
        }

    }

    @Override
    public List<Attendance> findAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public List<Attendance> findMonthlyAttendance(Integer empId, Integer year, String month) {
        List<Attendance> attendanceDetails = attendanceRepository.findByEmpId(empId);
        System.out.println("attendance" + attendanceDetails);
        List<Attendance> filteredList = attendanceDetails.stream()
                .filter(attendance -> (attendance.getYear().equals(year)) && (attendance.getMonth().equals(month)))
                .distinct()
                .collect(Collectors.toList());
        return filteredList;
    }

}

