package com.dushi.EmployeeService.hystrix;

import com.dushi.EmployeeService.model.Employee;
import com.dushi.EmployeeService.sharedModel.Attendance;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AttendanceCommand extends HystrixCommand<Attendance[]> {
    Employee employee;
    HttpHeaders httpHeaders;
    RestTemplate restTemplate;

    public AttendanceCommand(Employee employee, HttpHeaders httpHeaders, RestTemplate restTemplate){
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.employee = employee;
        this.httpHeaders = httpHeaders;
        this.restTemplate = restTemplate;
    }

    @Override
    protected Attendance[] run() throws Exception {
        httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>("",httpHeaders);
        System.out.println("attendance []"+ employee.getEmpId());
        ResponseEntity<Attendance[]> responseEntity = restTemplate.exchange("http://attendanceService:8282/payroll/findAttendance/"+ employee.getEmpId(), HttpMethod.GET,httpEntity,Attendance[].class);
        System.out.println(responseEntity.getBody().length+" >>>>>>>>>>>>>>>>>>>>>>>>>");
        return responseEntity.getBody();
    }

    @Override
    protected Attendance[] getFallback() {
        return new Attendance[1];
    }
}
