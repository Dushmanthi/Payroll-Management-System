package com.dushi.PaymentService.service;

import com.dushi.PaymentService.model.Payment;
import com.dushi.PaymentService.model.Salary;
import com.dushi.PaymentService.repository.PaymentRepository;
import com.dushi.PaymentService.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
//    @Autowired
//    SalaryRepository salaryRepository;


    @Autowired
    SalaryCalculationService salaryCalculationService;

    @Override
    public Payment savePayment(Payment payment) {
      //  Payment newPayment=paymentRepository.save(payment);
        payment.setDaySalary(salaryCalculationService.salaryCalculation(payment.getWorkingHours(), payment.getHourlypay()));
        Payment newPayment=paymentRepository.save(payment);
     //   payment.setMonthlySalary(salaryCalculationService.monthlySalaryCalculation(payment.getEmpId(), payment.getYear(), payment.getMonth()));
        return newPayment;

    }


//    @Override
//    public List<Payment> findByEmpId(Integer empId) {
//        return paymentRepository.findAllByEmpId(empId);
//    }

//    @Override
//    public Payment update(Payment payment) {
//        return paymentRepository.save(payment);
//    }
    @Override
    public Payment update(Payment payment) {
        Optional<Payment> existingPayment =  paymentRepository.findById(payment.getId());
        System.out.println();
        if(existingPayment.isPresent()){
            Payment payment1 = existingPayment.get();
            payment1.setEmpId(payment.getEmpId());
            payment1.setYear(payment.getYear());
            payment1.setMonth(payment.getMonth());
            payment1.setDay(payment.getDay());
            payment1.setWorkingHours(payment.getWorkingHours());
            payment1.setHourlypay(payment.getHourlypay());
            payment1.setDaySalary(salaryCalculationService.salaryCalculation(payment.getWorkingHours(), payment.getHourlypay()));
        //    payment1.setMonthlySalary(salaryCalculationService.monthlySalaryCalculation(payment.getEmpId(), payment.getYear(), payment.getMonth()));
            return paymentRepository.save(payment1);
        }
       else{
           return null;

        }
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> findPayment(Integer id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Map<String, Boolean> deletePayment(Integer id) {
        Optional<Payment> payment  = paymentRepository.findById(id);
        if(payment.isPresent()){
            Payment payment1=payment.get();
            paymentRepository.deleteById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }
        else {
            return null;
        }

    }

    @Override
    public Double findMonthlySalary(Integer empId, Integer year, String month) {
        System.out.println("salary");
        List<Payment> paymentDetails = paymentRepository.findByEmpId(empId);
        System.out.println("pay" + paymentDetails);
        double monthlySalary = paymentDetails.stream()
                .filter(payment -> (payment.getYear().equals(year)) && (payment.getMonth().equals(month)))
                .distinct()
                .filter(payment -> (payment != null && payment.getDaySalary() != null))
                .mapToDouble(Payment::getDaySalary)
                .sum();
        if(paymentDetails.isEmpty()){
            return null;
        }
        else{
            Payment payment1 = new Payment();
            payment1.setMonthlySalary(monthlySalary);
            paymentRepository.save(payment1);
            return monthlySalary;

        }
    }



//    @Override
//    public Salary findMonthlySalary(Integer empId, Integer year, String month) {
//            System.out.println("salary");
//            List<Payment> paymentDetails = paymentRepository.findByEmpId(empId);
//            System.out.println("pay" + paymentDetails);
//            double monthlySalary = paymentDetails.stream()
//                    .filter(payment -> (payment.getYear().equals(year)) && (payment.getMonth().equals(month)))
//                    .distinct()
//                    .filter(payment -> (payment != null && payment.getDaySalary() != null))
//                    .mapToDouble(Payment::getDaySalary)
//                    .sum();
//            Salary salary = new Salary();
//            salary.setEmpId(empId);
//            salary.setYear(year);
//            salary.setMonth(month);
//            salary.setMonthlySalary(monthlySalary);
//            System.out.println("monthlySalary"+monthlySalary);
//            return salaryRepository.save(salary);
//
//            // return salary;
//        }

    }

