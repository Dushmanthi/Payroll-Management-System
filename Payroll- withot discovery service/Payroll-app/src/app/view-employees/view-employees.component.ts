import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';
import {EmployeeService} from '../employee.service';
import {Employee} from '../add-employee/employee';

@Component({
  selector: 'app-view-employees',
  templateUrl: './view-employees.component.html',
  styleUrls: ['./view-employees.component.css']
})
export class ViewEmployeesComponent implements OnInit {

  employees: Observable<Employee[]>;

  constructor(private employeeService:EmployeeService, private router:Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.employees = this.employeeService.getEmployeeList();
  }

  deleteEmployee(id:number){
    this.employeeService.deleteEmployee(id)
      .subscribe(data=>{
          console.log(data);
          this.reloadData();
        },
        error=>{
          console.log(error);
        });
  }

  employeeDetails(id:number){
    this.router.navigate(['employee-details',id]);
  }

  updateEmployee(id: number){
    this.router.navigate(['update-employee', id]);
  }

  addEmployee(){
    this.router.navigate(['add-employee']);
  }


}
