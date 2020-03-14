package com.dushi.PaymentService.controller;

import com.dushi.PaymentService.model.Payment;
import com.dushi.PaymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PaymentServiceController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Payment test(){
        Payment payment = new Payment();
        payment.setEmpId(1002);
        payment.setYear(2019);
        payment.setMonth("march");
        payment.setDay(1);
        payment.setWorkingHours(9.0);
        payment.setHourlypay(100.00);
        payment.setDaySalary((payment.getWorkingHours())*(payment.getHourlypay()));
    //    payment.setMonthlySalary((payment.getDaySalary()*31));
    //    payment.setPaid(true);

        return payment;
    }

    @RequestMapping(value = "/savePayment",method = RequestMethod.POST)
    public Payment save(@RequestBody Payment payment){
        return paymentService.savePayment(payment);
    }

    @RequestMapping(value = "/findPayment/{empId}",method = RequestMethod.GET)
    public List<Payment> findEmployeePayment(@PathVariable("empId") Integer empId){
        return paymentService.findByEmpId(empId);
    }

    //update
    @RequestMapping(value = "/updatePayment/{empId}",method = RequestMethod.PUT)
    public Payment updatePayment(@RequestBody Payment payment){
        return paymentService.update(payment);
    }


}
