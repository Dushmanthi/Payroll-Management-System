package com.dushi.PaymentService.service;

import com.dushi.PaymentService.model.Payment;

import java.util.List;

public interface PaymentService {
    
    Payment savePayment(Payment payment);

    List<Payment> findByEmpId(Integer empId);

    Payment update(Payment payment);

    public Double salaryCalculation(Double workingHours, Double hourlypay);
}
