import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpClient: HttpClient) { }

  createEmployee(employee: Object):Observable<Object>{
    return this.httpClient.post('http://localhost:8181/api/employees/add-employee',employee);
  }

  getEmployee(empId: number): Observable<any> {
    return this.httpClient.get('http://localhost:8181/api/employees/findById/'+empId);
  }

  getEmployeeList(): Observable<any> {
    return this.httpClient.get('http://localhost:8181/api/employees/findAllEmployees');
  }

  updateEmployee(empId: number, value: any): Observable<Object> {
    return this.httpClient.put('http://localhost:8181/api/employees/updateEmployee/'+empId, value);
  }

  deleteEmployee(empId: number): Observable<any> {
    return this.httpClient.delete('http://localhost:8181/api/employees/deleteEmployee/'+empId, { responseType: 'text' });
  }

}
