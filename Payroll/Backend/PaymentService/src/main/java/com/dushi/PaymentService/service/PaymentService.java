package com.dushi.PaymentService.service;

import com.dushi.PaymentService.model.Payment;
import com.dushi.PaymentService.model.Salary;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PaymentService {
    
    Payment savePayment(Payment payment);

    Payment update(Payment payment);

    List<Payment> findAll();

    Optional<Payment> findPayment(Integer id);

    Map<String, Boolean> deletePayment(Integer id);

    Double findMonthlySalary(Integer empId, Integer year, String month);

}
