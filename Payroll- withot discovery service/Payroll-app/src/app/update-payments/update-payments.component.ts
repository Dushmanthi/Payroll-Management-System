import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Payment} from '../add-payment/payment';
import {PaymentService} from '../payment.service';

@Component({
  selector: 'app-update-payments',
  templateUrl: './update-payments.component.html',
  styleUrls: ['./update-payments.component.css']
})
export class UpdatePaymentsComponent implements OnInit {

  empId: number;
  payment : Payment;
  constructor(private route: ActivatedRoute,private router: Router,private paymentService: PaymentService) { }

  ngOnInit() {
    this.payment = new Payment();
    this.empId = this.route.snapshot.params['empId'];
    this.paymentService.getPayment(this.empId)
      .subscribe(data=>{
        console.log(data);
        this.payment = data;
      },error => console.log(error));
  }

  updatePayment(){
    console.log("data update stated");
    this.paymentService.updatePayment(this.empId,this.payment)
      .subscribe(data=>console.log(data),
        error=>console.log(error));
    this.payment = new Payment();
    this.gotoList();
  }

  onSubmit() {
    console.log("click update");
    this.updatePayment();
  }

  gotoList() {
    console.log("navigate update");
    this.router.navigate(['view-payment']);
  }


}
