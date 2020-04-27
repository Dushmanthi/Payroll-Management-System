package com.dushi.PaymentService.service;

import com.dushi.PaymentService.model.Payment;
import com.dushi.PaymentService.model.Salary;
import com.dushi.PaymentService.repository.PaymentRepository;
import com.dushi.PaymentService.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SalaryCalculationServiceImpl implements SalaryCalculationService {
    @Autowired
    SalaryRepository salaryRepository;
    @Autowired
    PaymentRepository paymentRepository;

    public Double salaryCalculation(Double workingHours, Double hourlypay) {
        System.out.println("day salary");
        Double daySalary = 0.0;

        daySalary = (hourlypay * workingHours);
        System.out.println("day salary:" + daySalary);
        return daySalary;
    }

    @Override
    public Salary findySalary(Integer empId, Integer year, String month) {
        Payment payment1 = new Payment();
                List<Payment> paymentDetails = paymentRepository.findByEmpId(empId);
        System.out.println("pay" + paymentDetails);
        double monthlySalary = paymentDetails.stream()
                .filter(payment -> (payment.getYear().equals(year)) && (payment.getMonth().equals(month)))
                .distinct()
                .filter(payment -> (payment != null && payment.getDaySalary() != null))
                .mapToDouble(Payment::getDaySalary)
                .sum();
        Optional<Salary> salary1 = salaryRepository.findByEmpId(empId);
        if(salary1.isPresent()){
            Salary salary= salary1.get();
        salary.setEmpId(empId);
        salary.setYear(year);
        salary.setMonth(month);
        salary.setMonthlySalary(monthlySalary);
         return salaryRepository.save(salary);
        }
        else{
          return null;

        }
    }

    @Override
    public Salary saveSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

//    @Override
//    public Double monthlySalaryCalculation(Integer empId, Integer year, String month) {
//        System.out.println("salary");
//        List<Payment> paymentDetails = paymentRepository.findByEmpId(empId);
//        System.out.println("pay" + paymentDetails);
//        double monthlySalary = paymentDetails.stream()
//                .filter(payment -> (payment.getYear().equals(year)) && (payment.getMonth().equals(month)))
//                .distinct()
//                .filter(payment -> (payment != null && payment.getDaySalary() != null))
//                .mapToDouble(Payment::getDaySalary)
//                .sum();
////        Salary salary = new Salary();
////        salary.setEmpId(empId);
////        salary.setYear(year);
////        salary.setMonth(month);
////        salary.setMonthlySalary(monthlySalary);
////        salaryRepository.save(salary);
//        if(paymentDetails.isEmpty()){
//            return null;
//        }
//        else{
//            Payment payment1 = new Payment();
//            payment1.setMonthlySalary(monthlySalary);
//        //    paymentRepository.save(payment1);
//            return monthlySalary;
//
//        }
//    }
//


}

