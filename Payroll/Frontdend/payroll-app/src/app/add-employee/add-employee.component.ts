import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {EmployeeService} from '../employee.service';
import {Employee} from './employee';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  //validation
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
  designation: new FormControl('',Validators.required)
  // hourlypay: new FormControl(0,Validators.required),
  // maximumWorkingHours: new FormControl(9,Validators.required)
  });

  employees: Observable<Employee[]>;
  employee: Employee = new Employee();
  submitted = false;

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  save() {
    this.employeeService.createEmployee(this.employee)
      .subscribe(data => {
          console.log(data);
        }
      , error => console.log(error));
    this.employee = new Employee();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
   // this.employees = this.employeeService.getEmployeeList();
    this.router.navigate(['view-employee']);
  }

}
