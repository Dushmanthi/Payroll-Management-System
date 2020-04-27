package com.dushi.EmployeeService.hystrix;

import com.dushi.EmployeeService.model.Employee;
import com.dushi.EmployeeService.sharedModel.Payment;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PaymentCommand extends HystrixCommand<Payment[]> {
    Employee employee;
    HttpHeaders httpHeaders;
    RestTemplate restTemplate;

    public PaymentCommand(Employee employee, HttpHeaders httpHeaders, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.employee = employee;
        this.httpHeaders = httpHeaders;
        this.restTemplate = restTemplate;
    }

    @Override
    protected Payment[] run() throws Exception {
        httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>("",httpHeaders);
        ResponseEntity<Payment[]> responseEntity = restTemplate.exchange("http://paymentService:8383/payroll/findPayment/"+ employee.getEmpId(), HttpMethod.GET,httpEntity,Payment[].class);
        return responseEntity.getBody();
    }

    @Override
    protected Payment[] getFallback() {
       // return super.getFallback();
        return new Payment[1];
    }
}
