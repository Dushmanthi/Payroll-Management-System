import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Payment} from '../add-payment/payment';
import {PaymentService} from '../payment.service';
import {Observable} from 'rxjs';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-update-payments',
  templateUrl: './update-payments.component.html',
  styleUrls: ['./update-payments.component.css']
})
export class UpdatePaymentsComponent implements OnInit {
  form = new FormGroup({
    empId: new FormControl(0,Validators.required),
    year : new FormControl(0,Validators.required),
    month:new FormControl('',Validators.required),
    day : new FormControl(0,Validators.required),
    workingHours: new FormControl(0,Validators.required),
    hourlypay: new FormControl(0,Validators.required)
  });

  empId : number;
  payment : Payment;
  payments: Observable<Payment[]>;
  constructor(private route: ActivatedRoute,private router: Router, private paymentService : PaymentService) { }

  ngOnInit() {
    this.payment = new Payment();
    this.empId = this.route.snapshot.params['empId'];
    console.log(this.empId);
    this.paymentService.getPayment(this.empId )
      .subscribe(data => {
        console.log("data");
        console.log(data);
        this.payment = data;
      }, error => console.log(error));
  }

  updatePayment(){
    console.log("data update stated");
    this.paymentService.updatePayment(this.empId,this.payment)
      .subscribe(data=>{
          console.log(data);
          this.gotoList();
        },
        error=>console.log(error));
    this.payment = new Payment();

  }

  onSubmit() {
    console.log("click update");
    this.updatePayment();
  }

  gotoList() {
    this.payments = this.paymentService.getPaymentList();
    this.router.navigate(['view-payment']);

  }


}
