package com.dushi.EmployeeService.service;

import com.dushi.EmployeeService.hystrix.AttendanceCommand;
import com.dushi.EmployeeService.hystrix.PaymentCommand;
import com.dushi.EmployeeService.model.EmployeeDetails;
import com.dushi.EmployeeService.repository.EmployeeRepository;
import com.dushi.EmployeeService.sharedModel.Attendance;
import com.dushi.EmployeeService.sharedModel.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public EmployeeDetails saveEmployee(EmployeeDetails employeeDetails) {
        return employeeRepository.save(employeeDetails);

    }

    //attendance
    public Attendance[] fetchAttendance(EmployeeDetails employeeDetails){
        HttpHeaders httpHeaders = new HttpHeaders();
        AttendanceCommand attendanceCommand = new AttendanceCommand(employeeDetails,httpHeaders,restTemplate);
        return attendanceCommand.execute();
    }

    //payment
    public Payment[] fetchPayment(EmployeeDetails employeeDetails){
        HttpHeaders httpHeaders = new HttpHeaders();
        PaymentCommand paymentCommand = new PaymentCommand(employeeDetails,httpHeaders,restTemplate);
        return paymentCommand.execute();
    }

    //find by empid
//    @Override
//    public EmployeeDetails findById(Integer id) {
//        Optional<EmployeeDetails> employeeDetails = employeeRepository.findByEmpId(id);
//        System.out.println(employeeDetails);
//        if(employeeDetails.isPresent()){
//            EmployeeDetails employee = employeeDetails.get();
//
//            employee.setAttendances(fetchAttendance(employee));
//            employee.setPayments(fetchPayment(employee));
//
//            System.out.println(employee.getAttendances()[0].getDay());
//            System.out.println(employee.getPayments()[0].getDaySalary());
//
//            System.out.println(fetchAttendance(employee));
//            System.out.println(fetchPayment(employee));
//
//            return employee;
//        }else {
//            return null;
//
//        }
//
//    }

    //
    @Override
    public EmployeeDetails findById(Integer id) {
        Optional<EmployeeDetails> employeeDetails1 = employeeRepository.findByEmpId(id);
        System.out.println("option value"+employeeDetails1);

        if(employeeDetails1.isPresent()) {
            EmployeeDetails employee = employeeDetails1.get();
//            System.out.println(employee.getEmpId());
            employee.setAttendances(fetchAttendance(employee));
            employee.setPayments(fetchPayment(employee));

//...........................
//            HttpHeaders httpHeaders = new HttpHeaders();
//            HttpEntity<String> httpEntity = new HttpEntity<>("",httpHeaders);
//            ResponseEntity<Attendance[]> responseEntity = restTemplate.exchange("http://attendance:8282/payroll/findAttendance/"+ id, HttpMethod.GET,httpEntity,Attendance[].class);
//            Attendance[] body = responseEntity.getBody();
//            for (Attendance attendance: body){
//                System.out.println(attendance.getDay()+" "+attendance.getId());
//            }
//            employee.setAttendances(body);
            return employee;
        }
        else {
            System.out.println("null");
            return null;

        }

        }


    //find all employee
    @Override
    public List<EmployeeDetails> findAll() {
        return employeeRepository.findAll();
    }

    //update
    @Override
    public EmployeeDetails updateEmployee(Integer id) {
        if(employeeRepository.existsById(id)){
            EmployeeDetails employeeDetails = employeeRepository.getOne(id);
            employeeRepository.save(employeeDetails);
            return employeeDetails;
        }
       return null;
    }

    //delete by id
    @Override
    public Boolean deleteEmployee(Integer id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }

    }


}
