package com.dushi.AttendanceService.controller;

import com.dushi.AttendanceService.model.Attendance;
import com.dushi.AttendanceService.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceServiceController {
    @Autowired
    AttendanceService attendanceService;

    @RequestMapping(value = "/saveAttendance",method = RequestMethod.POST)
    public Attendance save(@Valid @RequestBody Attendance attendance){
        return attendanceService.saveAttendance(attendance);
    }

    @RequestMapping(value = "/findAttendance/{empId}",method = RequestMethod.GET)
    public List<Attendance> findEmployeeAttendance(@PathVariable("empId") Integer empId){
        return attendanceService.findEmp(empId);
    }

    @RequestMapping(value = "/findAllAttendance",method = RequestMethod.GET)
    public List<Attendance> findAll(){
        return attendanceService.findAllAttendance();
    }

    //find monthly attendance
    @RequestMapping(value = "/monthlyAttendance/{empId}/{year}/{month}",method = RequestMethod.GET)
    public List<Attendance> findMonthlyAttendance(@PathVariable("empId") Integer empId,
                                     @PathVariable("year") Integer year,
                                     @PathVariable("month") String month){
        return (List<Attendance>) attendanceService.findMonthlyAttendance(empId,year,month);
    }

    //find by id
    @RequestMapping(value = "/findAttendanceById/{id}",method = RequestMethod.GET)
    public Optional<Attendance> findAttendance(@PathVariable("id") Integer id){
        return attendanceService.findAttendance(id);
    }

    //update
    @RequestMapping(value = "/updateAttendance/{id}",method = RequestMethod.PUT)
    public Attendance updateAttendance(@Valid @RequestBody Attendance attendance,@PathVariable("id") Integer id){
        System.out.println("id"+id);
        return attendanceService.update(attendance,id);
    }

    @RequestMapping(value = "/deleteAttendance/{id}",method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteAttendance(@PathVariable(value = "id") Integer id){
        return attendanceService.deleteAttendance(id);
    }

}
