package com.dushi.PaymentService.repository;

import com.dushi.PaymentService.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {

    Optional<Salary> findByEmpId(Integer empId);
}
