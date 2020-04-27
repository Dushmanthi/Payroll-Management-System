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

  getEmployee(id: number): Observable<any> {
    return this.httpClient.get('http://localhost:8181/api/employees/findById/'+id);
  }

  getEmployeeList(): Observable<any> {
    return this.httpClient.get('http://localhost:8181/api/employees/findAllEmployees');
  }

  updateEmployee(id: number, value: any): Observable<Object> {
    return this.httpClient.put('http://localhost:8181/api/employees/updateEmployee/'+id, value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.httpClient.delete('http://localhost:8181/api/employees/deleteEmployee/'+id, { responseType: 'text' });
  }

}
