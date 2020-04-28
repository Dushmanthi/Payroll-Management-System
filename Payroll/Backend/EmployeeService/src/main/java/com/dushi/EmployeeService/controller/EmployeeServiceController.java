package com.dushi.EmployeeService.controller;

import com.dushi.EmployeeService.model.Employee;
import com.dushi.EmployeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeServiceController {
    @Autowired
    EmployeeService employeeService;

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public Employee test() {
//        Employee employee = new Employee();
//        employee.setEmpId(1001);
//        employee.setFirstName("dushi");
//       employeeDetails.setLastName("ferz");
//       employeeDetails.setAddress("gampaha");
//       employeeDetails.setContactNo(071234567);
//       employeeDetails.setEmail("dushi@gmail.com");
//       employeeDetails.setDesignation("ASE");
//       employeeDetails.setHourlypay(200.00);
//       employeeDetails.setMaximumWorkingHours(9);
//       employeeDetails.setPassword("1234");
//        return employee;
//    }

    //register employee
    @RequestMapping(value = "/add-employee", method = RequestMethod.POST)
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        //    employee.getAddress().setEmployee(employee);
        //    employee.getTelephone().stream().forEach(telephone -> telephone.setEmployee(employee));
        return employeeService.saveEmployee(employee);
    }
    //find by empId
    @RequestMapping(value = "/findByEmpId/{empId}", method = RequestMethod.GET)
    public Employee findByEmpId(@PathVariable("empId") Integer empId) {
        Employee employee = employeeService.findByEmployeeId(empId);
        return employee;
    }

    //findAll employee
    @RequestMapping(value = "/findAllEmployees", method = RequestMethod.GET)
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    //find by id
    @RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
    public Optional<Employee> findEmployee(@PathVariable("id") Integer id){
        return employeeService.findEmployee(id);
    }


    //update
    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
    public Employee updateEmp( @Valid @RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
        }
        
    //delete by id
    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
        public Map<String, Boolean> deleteEmp(@PathVariable(value = "id") Integer id){
        System.out.println("delete");
            return employeeService.deleteEmployee(id);
        }

}
