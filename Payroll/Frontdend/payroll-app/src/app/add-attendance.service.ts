import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddAttendanceService {

  constructor(private httpClient: HttpClient) { }

  addAttendance(attendance: Object):Observable<Object>{
  return this.httpClient.post('http://localhost:8282/api/attendance/saveAttendance',attendance);
  }

  getAttendance(empId: number): Observable<any> {
    return this.httpClient.get('http://localhost:8282/api/attendance/findAttendance/'+empId);
  }

  getAttendanceList(): Observable<any> {
    return this.httpClient.get('http://localhost:8282/api/attendance/findAllAttendance');
  }

  updateAttendance(empId: number, value: any): Observable<Object> {
    return this.httpClient.put('http://localhost:8282/api/attendance/updateAttendance/'+empId, value);
  }

  deleteAttendance(empId: number): Observable<any> {
    return this.httpClient.delete('http://localhost:8282/api/attendance/attendance/'+empId, { responseType: 'text' });
  }
}
