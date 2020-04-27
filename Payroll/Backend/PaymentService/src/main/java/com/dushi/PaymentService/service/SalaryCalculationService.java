package com.dushi.PaymentService.service;

import com.dushi.PaymentService.model.Salary;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface SalaryCalculationService {
    //public Double DaySalaryCalculation(Double workingHours, Double hourlypay, String month);
    public Double salaryCalculation(Double workingHours, Double hourlypay);

  //  Double monthlySalaryCalculation(Integer empId, Integer year, String month);

    Salary findySalary(Integer empId, Integer year, String month);

    Salary saveSalary(Salary salary);

    // Salary findMonthlySalary(Integer empId, Integer year, String month);

    // Double Salary(Integer empId);
}
