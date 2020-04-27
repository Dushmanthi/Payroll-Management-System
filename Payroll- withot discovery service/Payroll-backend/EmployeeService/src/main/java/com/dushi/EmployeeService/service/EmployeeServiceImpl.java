package com.dushi.EmployeeService.service;

import com.dushi.EmployeeService.hystrix.AttendanceCommand;
import com.dushi.EmployeeService.hystrix.PaymentCommand;
import com.dushi.EmployeeService.model.Employee;
import com.dushi.EmployeeService.repository.EmployeeRepository;
import com.dushi.EmployeeService.sharedModel.Attendance;
import com.dushi.EmployeeService.sharedModel.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }

    //attendance
    public Attendance[] fetchAttendance(Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        AttendanceCommand attendanceCommand = new AttendanceCommand(employee, httpHeaders, restTemplate);
        return attendanceCommand.execute();
    }

    //payment
    public Payment[] fetchPayment(Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        PaymentCommand paymentCommand = new PaymentCommand(employee, httpHeaders, restTemplate);
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
    public Employee findByEmployeeId(Integer id) {
        Optional<Employee> employeeDetails1 = employeeRepository.findByEmpId(id);
        System.out.println("option value" + employeeDetails1);

        if (employeeDetails1.isPresent()) {
            Employee employee = employeeDetails1.get();
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
        } else {
            System.out.println("null");
            return null;

        }

    }

    //find all employee
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //update
    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getId());
        if (existingEmployee.isPresent()) {
            Employee employee1 = existingEmployee.get();
            employee1.setEmpId(employee.getEmpId());
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employee1.setNumber(employee.getNumber());
            employee1.setStreet(employee.getStreet());
            employee1.setCity(employee.getCity());
            employee1.setPhoneNumber(employee.getPhoneNumber());
            employee1.setEmail(employee.getEmail());
            employee1.setDesignation(employee.getDesignation());
//            employee1.setHourlypay(employee.getHourlypay());
            employee1.setEmail(employee.getEmail());
//            employee1.setMaximumWorkingHours(employee.getMaximumWorkingHours());

            return employeeRepository.save(employee1);
        } else {
            return null;

        }
    }


    //find by id
    @Override
    public Optional<Employee> findEmployee(Integer id) {
        return employeeRepository.findById(id);
    }

    //delete by id
    @Override

    public Map<String, Boolean> deleteEmployee(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        System.out.println(employee);
        if (employee.isPresent()) {
            Employee employee1 = employee.get();
            employeeRepository.deleteById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        } else {
            return null;
        }

    }

}
