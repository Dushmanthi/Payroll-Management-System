import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private httpClient: HttpClient) { }

  addPayment(payment: Object):Observable<Object>{
    return this.httpClient.post('http://localhost:8383/api/payments/add-payments',payment);
  }

  getPayment(empId: number): Observable<any> {
    return this.httpClient.get('http://localhost:8383/api/payments/findPayment/'+empId);
  }

  getPaymentList(): Observable<any> {
    return this.httpClient.get('http://localhost:8383/api/payments/findAllPayment');
  }

  updatePayment(empId: number, value: any): Observable<Object> {
    return this.httpClient.put('http://localhost:8383/api/payments/updatePayment/'+empId, value);
  }

  deletePayment(empId: number): Observable<any> {
    return this.httpClient.delete('http://paymentService:8383/api/payments/deletePayment/'+empId, { responseType: 'text' });
  }

}
