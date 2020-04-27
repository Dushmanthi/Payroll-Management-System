package com.dushi.PaymentService.service;

import com.dushi.PaymentService.model.Payment;
import com.dushi.PaymentService.model.Salary;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PaymentService {
    
    Payment savePayment(Payment payment);

//    List<Payment> findByEmpId(Integer id);

    Payment update(Payment payment);

//    double findMonthlySalary(Integer empId, Integer year, String month);

    List<Payment> findAll();

    Optional<Payment> findPayment(Integer id);

    Map<String, Boolean> deletePayment(Integer id);

    Double findMonthlySalary(Integer empId, Integer year, String month);

//    public Boolean deletePayment(Integer id);
}
