import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';
import {PaymentService} from '../payment.service';
import {Payment} from '../add-payment/payment';

@Component({
  selector: 'app-view-payments',
  templateUrl: './view-payments.component.html',
  styleUrls: ['./view-payments.component.css']
})
export class ViewPaymentsComponent implements OnInit {
  payments: Observable<Payment[]>;

  constructor(private paymentService:PaymentService, private router:Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.payments = this.paymentService.getPaymentList();
  }

  deletePayment(empId:number){
    this.paymentService.deletePayment(empId)
      .subscribe(data=>{
          console.log(data);
          this.reloadData();
        },
        error=>{
          console.log(error);
        });
  }

  paymentDetails(empId:number){
    this.router.navigate(['payment-details',empId]);
  }

  updatePayment(empId: number){
    console.log("clikkkkkk");
    this.router.navigate(['update-payment', empId]);
  }


}
