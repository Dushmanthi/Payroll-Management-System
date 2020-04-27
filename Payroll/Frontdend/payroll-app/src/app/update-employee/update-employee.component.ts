import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Employee} from '../add-employee/employee';
import {EmployeeService} from '../employee.service';
import {Observable} from 'rxjs';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  form = new FormGroup({
    empId: new FormControl(0,Validators.required),
    firstName: new FormControl('',Validators.required),
    username:new FormControl('',Validators.required),
    lastName: new FormControl('',Validators.required),
    number: new FormControl('',Validators.required),
    street: new FormControl('',Validators.required),
    city: new FormControl('',Validators.required),
    phoneNumber: new FormControl('',[Validators.required,Validators.minLength(10)]),
    email: new FormControl('',[Validators.required,Validators.email]),
    designation: new FormControl('',Validators.required),
    hourlypay: new FormControl(0,Validators.required),
    maximumWorkingHours: new FormControl(9,Validators.required)
  });


  empId: number;
  employee : Employee;
  employees: Observable<Employee[]>;
  constructor(private route: ActivatedRoute,private router: Router,private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employee = new Employee();
    this.empId = this.route.snapshot.params['empId'];
    this.employeeService.getEmployee(this.empId)
      .subscribe(data=>{
        console.log(data);
        this.employee = data;
      },error => console.log(error));
  }

  updateEmployee(){
    console.log("data update stated");
    this.employeeService.updateEmployee(this.empId,this.employee)
      .subscribe(data=>console.log(data),
        error=>console.log(error));
    this.employee = new Employee();
    this.gotoList();
  }

  onSubmit() {
    console.log("click update");
    this.updateEmployee();
  }

  gotoList() {
    console.log("navigate update");
    this.employees = this.employeeService.getEmployeeList();
    this.router.navigate(['view-employee']);
  }


}
