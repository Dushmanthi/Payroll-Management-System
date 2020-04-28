package com.dushi.PaymentService.service;

import com.dushi.PaymentService.model.Salary;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface SalaryCalculationService {
    public Double salaryCalculation(Double workingHours, Double hourlypay);

    Salary findySalary(Integer empId, Integer year, String month);

    Salary saveSalary(Salary salary);

}
