package com.dushi.PaymentService.service;

import com.dushi.PaymentService.model.Payment;
import com.dushi.PaymentService.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

//    @Autowired
//    ApplicationContext applicationContext;

    @Autowired
    SalaryCalculationService salaryCalculationService;

//    @Bean
//    public SalaryCalculationService salaryCalculationService(){
////        return applicationContext.getBean(SalaryCalculationService.class);
//    return new SalaryCalculationServiceImpl();
//    }


    @Override
    public Payment savePayment(Payment payment) {
        //payment.setMonthlySalary(SalaryCalculation(payment.getWorkingHours(),payment.getHourlypay(),payment.getMonth()));
        payment.setDaySalary(salaryCalculationService.salaryCalculation(payment.getWorkingHours(),payment.getHourlypay()));
        return paymentRepository.save(payment);
    }


    @Override
    public List<Payment> findByEmpId(Integer empId) {
        return paymentRepository.findAllByEmpId(empId);
    }

    @Override
    public Payment update(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Double salaryCalculation(Double workingHours, Double hourlypay) {
       // Double monthlySalary = 0.0;
        Double daySalary = 0.0;

       // if (month.equals(month)) {
        //    for (int day = 1; day < 32; day++) {
                daySalary = (hourlypay * workingHours);
                System.out.println("day salary:" + daySalary);

              //  monthlySalary += daySalary;
              //  System.out.println("monthly salary:" + monthlySalary);
                return daySalary;
            }

      //  }
      //  return monthlySalary;
    //}


}
