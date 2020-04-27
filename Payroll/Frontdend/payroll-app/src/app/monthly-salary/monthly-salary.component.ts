import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Salary} from '../monthly-payment/salary';
import {Payment} from '../add-payment/payment';
import {PaymentService} from '../payment.service';
@Component({
  selector: 'app-monthly-salary',
  templateUrl: './monthly-salary.component.html',
  styleUrls: ['./monthly-salary.component.css']
})
export class MonthlySalaryComponent implements OnInit {
  empId : number;
  year: number;
  month: string;
  salary: Salary;
  constructor(private route: ActivatedRoute,private router: Router, private paymentService : PaymentService) { }

  ngOnInit() {
    this.salary = new Salary();
    this.empId = this.route.snapshot.params['empId'];
    this.year = this.route.snapshot.params['year'];
    this.month = this.route.snapshot.params['month'];
    // this.empId = this.form.get('empId').value;
    // this.year = this.form.get('year').value;
    // this.month = this.form.get('month').value;
    console.log(this.empId);
    console.log(this.year);
    console.log(this.month);
    this.paymentService.getMonthlySalary(this.empId,this.year,this.month)
      .subscribe(data => {
        console.log("data");
        console.log(data);
        this.salary = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['view-payment']);
  }

}
