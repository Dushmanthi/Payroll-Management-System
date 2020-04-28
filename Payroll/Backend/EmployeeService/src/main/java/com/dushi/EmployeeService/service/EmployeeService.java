package com.dushi.EmployeeService.service;

import com.dushi.EmployeeService.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> findAll();

    Employee updateEmployee(Employee employee);

    Optional<Employee> findEmployee(Integer id);

    Employee findByEmployeeId(Integer empId);

    Map<String, Boolean> deleteEmployee(Integer id);

    // EmployeeDetails findByEmpId(Integer id);
}
