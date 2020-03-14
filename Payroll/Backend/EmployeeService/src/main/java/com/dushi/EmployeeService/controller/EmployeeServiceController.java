package com.dushi.EmployeeService.controller;

import com.dushi.EmployeeService.exception.ResourceNotFoundException;
import com.dushi.EmployeeService.model.EmployeeDetails;
import com.dushi.EmployeeService.service.EmployeeService;
import com.dushi.EmployeeService.sharedModel.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/employee")
public class EmployeeServiceController {
    @Autowired
    EmployeeService employeeService;

//    //login
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public boolean save(@RequestBody EmployeeDetails employee){
//        if (employeeService.loginEmployee(employee)) return true;
//        else return false;
//    }
   @RequestMapping(value = "/test",method = RequestMethod.GET)
   public EmployeeDetails test(){
       EmployeeDetails employeeDetails=new EmployeeDetails();
       employeeDetails.setEmpId(1001);
       employeeDetails.setFirstName("dushi");
//       employeeDetails.setLastName("ferz");
//       employeeDetails.setAddress("gampaha");
//       employeeDetails.setContactNo(071234567);
//       employeeDetails.setEmail("dushi@gmail.com");
//       employeeDetails.setDesignation("ASE");
//       employeeDetails.setHourlypay(200.00);
//       employeeDetails.setMaximumWorkingHours(9);
//       employeeDetails.setPassword("1234");
       return employeeDetails;
   }

    //register employee
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public EmployeeDetails createEmployee(@RequestBody EmployeeDetails employeeDetails){
       employeeDetails.getAddress().setEmployeeDetails(employeeDetails);
       employeeDetails.getTelephone().stream().forEach(telephone -> telephone.setEmployeeDetails(employeeDetails));
        return employeeService.saveEmployee(employeeDetails);
    }

        @RequestMapping(value = "/findById/{empId}",method = RequestMethod.GET)
    public EmployeeDetails findByEmpId(@PathVariable("empId") Integer empId){
            EmployeeDetails employee = employeeService.findById(empId);
                    return employee;
           // return ResponseEntity.ok().body(employee);

        }

    //findAll employee
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
     public List<EmployeeDetails> findAll(){
        return employeeService.findAll();
    }

    @RequestMapping(value = "/updateById/{id}",method = RequestMethod.PUT)
    public EmployeeDetails updateEmp(@PathVariable("id") Integer id,@Valid @RequestBody EmployeeDetails employeeDetails){
       return employeeService.updateEmployee(id);
//        EmployeeDetails employee = employeeService.findById(id);
//        employee.setFirstName(employeeDetails.getFirstName());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setAddress(employeeDetails.getAddress());
//        employee.setEmail(employeeDetails.getEmail());
//        employee.setDesignation(employeeDetails.getDesignation());
//        employee.setHourlypay(employeeDetails.getHourlypay());
//        employee.setEmail(employeeDetails.getEmail());
//        employee.setMaximumWorkingHours(employeeDetails.getMaximumWorkingHours());
//        final EmployeeDetails updatedEmployee = employeeService.saveEmployee(employee);
//        return updatedEmployee;
        // return ResponseEntity.ok(updatedEmployee);
    }
    //delete by id
    @RequestMapping(value = "/deleteById/{id}",method = RequestMethod.GET)
    public Boolean deleteEmp(@PathVariable("id") Integer id){
        return employeeService.deleteEmployee(id);
    }

    @RequestMapping(value = "/updateById/{id}",method = RequestMethod.GET)
    public EmployeeDetails findDaySalary(@PathVariable("id") Integer id) {
        return employeeService.updateEmployee(id);

    }
}
