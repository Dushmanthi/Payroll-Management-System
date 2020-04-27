import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {PaymentService} from '../payment.service';
// import {Payment} from '../add-payment/payment';
// import {Attendance} from '../add-attendance/attendance';
import {Salary} from './salary';
import {Payment} from '../add-payment/payment';

@Component({
  selector: 'app-monthly-payment',
  templateUrl: './monthly-payment.component.html',
  styleUrls: ['./monthly-payment.component.css']
})
export class MonthlyPaymentComponent implements OnInit {
  form = new FormGroup({
    empId: new FormControl(0,Validators.required),
    year : new FormControl(0,Validators.required),
    month:new FormControl('',Validators.required)
  });
  empId : number;
  year: number;
  month: string;
  salary: Salary= new Salary();
  submitted = false;
  constructor(private route: ActivatedRoute,private router: Router, private paymentService:PaymentService ) { }

  ngOnInit() {

  }

  newSalary():void{
    this.submitted = false;
    this.salary = new Salary();
  }

  save(){
    this.paymentService.addSalary(this.salary)
      .subscribe(data=>console.log(data),
        error=>console.log(error));
    this.salary = new Salary();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.salary = new Salary();
      this.empId = this.form.get('empId').value;
      this.year = this.form.get('year').value;
      this.month = this.form.get('month').value;
      console.log(this.empId);
      console.log(this.year);
      console.log(this.month);
      this.paymentService.getMonthlySalary(this.empId,this.year,this.month)
        .subscribe(data => {
          console.log(data)
          this.salary = data;
        }, error => console.log(error));
    this.router.navigate(['monthly-salary']);
  }

  // onSubmit() {
  //   this.payment= new Payment();
  //
  //   this.empId = this.form.get('empId').value;
  //   this.year = this.form.get('year').value;
  //   this.month = this.form.get('month').value;
  //   console.log(this.empId);
  //   console.log(this.year);
  //   console.log(this.month);
  //   this.paymentService.getMonthlySalary(this.empId,this.year,this.month)
  //     .subscribe(data => {
  //       console.log(data)
  //       this.payment = data;
  //     }, error => console.log(error));
  //
  //   this.router.navigate(['monthly-salary']);
  // }

  // reloadData(){
  //  // this.this.paymentService.getMonthlySalary(this.empId,this.year,this.month)
  //   this.router.navigate(['monthly-salary']);
  // }

  // list(){
  //   this.router.navigate(['view-payment']);
  // }


}
