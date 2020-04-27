import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Employee} from '../add-employee/employee';
import {EmployeeService} from '../employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
  empId : number;
  employee : Employee;
  constructor(private route: ActivatedRoute,private router: Router, private employeeService : EmployeeService) { }

  ngOnInit() {
    this.employee = new Employee();
    this.empId = this.route.snapshot.params['empId'];

    this.employeeService.getEmployee(this.empId)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['add-employee']);
  }
}
