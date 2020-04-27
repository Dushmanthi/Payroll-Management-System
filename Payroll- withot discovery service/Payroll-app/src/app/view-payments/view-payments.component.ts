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

  deletePayment(id:number){
    console.log(id);
    this.paymentService.deletePayment(id)
      .subscribe(data=>{
          console.log(data);
          this.reloadData();
        },
        error=>{
          console.log(error);
        });

  }

  paymentDetails(id:number){
    console.log("details"+id);
    this.router.navigate(['payment-details',id]);
  }

  updatePayment(id: number){
    console.log("update"+id);
    this.router.navigate(['update-payment', id]);
  }

  addPayment(){
    this.router.navigate(['add-payment']);
  }

  viewMonthlyPayment(){
    this.router.navigate(['monthly-payment']);
  }


}
