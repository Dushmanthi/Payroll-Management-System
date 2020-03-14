package com.dushi.PaymentService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalaryCalculationServiceImpl implements SalaryCalculationService {

    public Double salaryCalculation(Double workingHours, Double hourlypay) {
       // Double monthlySalary = 0.0;
        Double daySalary = 0.0;

        //
        //   for (int day = 1; day < 32; day++) {
        daySalary = (hourlypay * workingHours);
        System.out.println("day salary:" + daySalary);

        //      monthlySalary = monthlySalary + daySalary;
        //     System.out.println("monthly salary:" + monthlySalary);
        return daySalary;
    }


}

