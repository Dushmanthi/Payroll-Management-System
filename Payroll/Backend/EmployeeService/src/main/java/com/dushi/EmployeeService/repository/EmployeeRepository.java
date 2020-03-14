package com.dushi.EmployeeService.repository;

import com.dushi.EmployeeService.model.EmployeeDetails;
import com.dushi.EmployeeService.sharedModel.Attendance;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails,Integer> {

    Optional<EmployeeDetails> findByEmpId(Integer id);

 //   List<Attendance> findAll(Example<Attendance> example);
}
