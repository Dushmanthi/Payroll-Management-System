package com.dushi.PaymentService.controller;

import com.dushi.PaymentService.model.Payment;
import com.dushi.PaymentService.model.Salary;
import com.dushi.PaymentService.service.PaymentService;
import com.dushi.PaymentService.service.SalaryCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentServiceController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    SalaryCalculationService salaryCalculationService;

//    @RequestMapping(value = "/test",method = RequestMethod.GET)
//    public Payment test(){
//        Payment payment = new Payment();
//        payment.setEmpId(1002);
//        payment.setYear(2019);
//        payment.setMonth("march");
//        payment.setDay(1);
//        payment.setWorkingHours(9.0);
//        payment.setHourlypay(100.00);
//        payment.setDaySalary((payment.getWorkingHours())*(payment.getHourlypay()));
//    //    payment.setMonthlySalary((payment.getDaySalary()*31));
//    //    payment.setPaid(true);
//
//        return payment;
//    }

    //save
    @RequestMapping(value = "/add-payments",method = RequestMethod.POST)
    public Payment save(@Valid @RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    //findAll employee
    @RequestMapping(value = "/findAllPayment",method = RequestMethod.GET)
    public List<Payment> findAll(){
        return paymentService.findAll();
    }

    //find by id
    @RequestMapping(value = "/findPayment/{id}",method = RequestMethod.GET)
    public Optional<Payment> findPayment(@PathVariable("id") Integer id){
        return paymentService.findPayment(id);
    }

    //update
    @RequestMapping(value = "/updatePayment/{id}",method = RequestMethod.PUT)
    public Payment updatePayment(@Valid @RequestBody Payment payment){
        return paymentService.update(payment);
    }

    @RequestMapping(value = "/deletePayment/{id}",method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer id){
        return paymentService.deletePayment(id);
    }

    //save
    @RequestMapping(value = "/add-salary",method = RequestMethod.POST)
    public Salary saveSalary(@Valid @RequestBody Salary salary) {
        return salaryCalculationService.saveSalary(salary);
    }

    @RequestMapping(value = "/monthlySalary/{empId}/{year}/{month}",method = RequestMethod.GET)
    public Salary findySalary(@PathVariable("empId") Integer empId,
                                     @PathVariable("year") Integer year,
                                     @PathVariable("month") String month){
        System.out.println("salary controller");
        return salaryCalculationService.findySalary(empId,year,month);
    }


}
