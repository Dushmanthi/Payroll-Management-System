import { Component, OnInit,Input } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Payment} from '../add-payment/payment';
import {PaymentService} from '../payment.service';
// import { ViewPaymentsComponent } from './view-payments/view-payments.component';

@Component({
  selector: 'app-payment-details',
  templateUrl: './payment-details.component.html',
  styleUrls: ['./payment-details.component.css']
})
export class PaymentDetailsComponent implements OnInit {
  empId : number;
  payment : Payment;
  constructor(private route: ActivatedRoute,private router: Router, private paymentService : PaymentService) { }

  ngOnInit() {
    this.payment = new Payment();
    this.empId = this.route.snapshot.params['empId'];

    this.paymentService.getPayment(this.empId)
      .subscribe(data => {
        console.log("data");
        console.log(data);
        this.payment = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['view-payment']);
  }
}
