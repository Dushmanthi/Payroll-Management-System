import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Employee} from '../add-employee/employee';
import {EmployeeService} from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  empId: number;
  employee : Employee;
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
    this.router.navigate(['view-employee']);
  }


}
