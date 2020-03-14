package com.dushi.EmployeeService.service;

import com.dushi.EmployeeService.model.EmployeeDetails;

import java.util.List;

public interface EmployeeService {
   // boolean loginEmployee(EmployeeDetails employee);

    EmployeeDetails saveEmployee(EmployeeDetails employeeDetails);

    EmployeeDetails findById(Integer id);

    List<EmployeeDetails> findAll();

    Boolean deleteEmployee(Integer id);

    EmployeeDetails updateEmployee(Integer id);

   // EmployeeDetails findByEmpId(Integer id);
}
