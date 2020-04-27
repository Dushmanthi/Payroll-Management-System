import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {PaymentService} from '../payment.service';
import {Payment} from './payment';
@Component({
  selector: 'app-add-payment',
  templateUrl: './add-payment.component.html',
  styleUrls: ['./add-payment.component.css']
})
export class AddPaymentComponent implements OnInit {
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
          this.router.navigate(['/register-success']);
        }

}
