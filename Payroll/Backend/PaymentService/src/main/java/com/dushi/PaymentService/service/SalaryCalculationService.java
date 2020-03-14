package com.dushi.PaymentService.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface SalaryCalculationService {
    //public Double DaySalaryCalculation(Double workingHours, Double hourlypay, String month);
    public Double salaryCalculation(Double workingHours, Double hourlypay);

   // Double Salary(Integer empId);
}
