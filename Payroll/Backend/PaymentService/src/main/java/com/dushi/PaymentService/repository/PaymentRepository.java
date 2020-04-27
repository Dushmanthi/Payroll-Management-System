package com.dushi.PaymentService.repository;

import com.dushi.PaymentService.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findAllByEmpId(Integer empId);

    List<Payment> findByEmpId(Integer empId);

    Optional<Payment> findById(Integer id);


}
