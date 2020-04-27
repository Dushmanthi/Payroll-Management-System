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

  getPayment(id: number): Observable<any> {
    return this.httpClient.get('http://localhost:8383/api/payments/findPayment/'+id);
  }

  getPaymentList(): Observable<any> {
    return this.httpClient.get('http://localhost:8383/api/payments/findAllPayment');
  }

  getMonthlySalary(empId: number,year:number,month:string):Observable<any> {
    return this.httpClient.get('http://localhost:8383/api/payments/monthlySalary/'+empId+'/'+year+'/'+month);
  }

  updatePayment(id: number, value: any): Observable<Object> {
    return this.httpClient.put('http://localhost:8383/api/payments/updatePayment/'+id, value);
  }

  deletePayment(id: number): Observable<any> {
    return this.httpClient.delete('http://localhost:8383/api/payments/deletePayment/'+id, { responseType: 'text' });
  }

  getSalary(empId: number): Observable<any> {
    return this.httpClient.get('http://localhost:8383/api/payments/findPayment/'+empId);
  }

  addSalary(salary: Object):Observable<Object>{
    console.log("save salary");
    return this.httpClient.post('http://localhost:8383/api/payments/add-salary',salary);
  }

}
