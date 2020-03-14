package com.dushi.AttendanceService.controller;

import com.dushi.AttendanceService.model.Attendance;
import com.dushi.AttendanceService.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class AttendanceServiceController {
    @Autowired
    AttendanceService attendanceService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Attendance test(){
        Attendance attendance = new Attendance();
        attendance.setEmpId(1002);
        attendance.setYear(2019);
        attendance.setMonth("march");
        attendance.setDay(1);
        attendance.setWorkingHours(9.0);
       // attendance.setPresent(true);

        return attendance;
    }

    @RequestMapping(value = "/saveAttendance",method = RequestMethod.POST)
    public Attendance save(@RequestBody Attendance attendance){
        return attendanceService.saveAttendance(attendance);
    }

    @RequestMapping(value = "/findAttendance/{empId}",method = RequestMethod.GET)
    public List<Attendance> findEmployeeAttendance(@PathVariable("empId") Integer empId){
        return attendanceService.findByEmpId(empId);
    }

    //update
    @RequestMapping(value = "/updateAttendance/{empId}",method = RequestMethod.PUT)
    public Attendance updateAttendance(@RequestBody Attendance attendance){
        return attendanceService.update(attendance);
    }

}
