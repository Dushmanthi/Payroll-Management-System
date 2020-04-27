import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {PaymentService} from '../payment.service';
import {Payment} from './payment';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
@Component({
  selector: 'app-add-payment',
  templateUrl: './add-payment.component.html',
  styleUrls: ['./add-payment.component.css']
})
export class AddPaymentComponent implements OnInit {
  form = new FormGroup({
    empId: new FormControl(0,Validators.required),
    year : new FormControl(0,Validators.required),
    month:new FormControl('',Validators.required),
    day : new FormControl(0,Validators.required),
    workingHours : new FormControl(0,Validators.required),
    hourlypay: new FormControl(0,Validators.required)
  });
  payments: Observable<Payment[]>;
payment: Payment = new Payment();
submitted = false;
  constructor(private paymentService: PaymentService ,private router: Router) { }

  ngOnInit() {
  }

    newPayment():void{
      this.submitted = false;
      this.payment = new Payment();
    }

    save(){
    this.paymentService.addPayment(this.payment)
      .subscribe(data=>console.log(data),
      error=>console.log(error));
      this.payment = new Payment();
      this.gotoList();
    }

    onSubmit() {
        this.submitted = true;
        this.save();
      }

      gotoList() {
      //  this.payments = this.paymentService.getPaymentList();
          this.router.navigate(['/view-payment']);
        }

}
