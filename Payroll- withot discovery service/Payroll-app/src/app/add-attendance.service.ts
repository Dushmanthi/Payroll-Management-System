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

  getAttendance(id: number): Observable<any> {
    return this.httpClient.get('http://localhost:8282/api/attendance/findAttendanceById/'+id);
  }

  getAttendanceList(): Observable<any> {
    return this.httpClient.get('http://localhost:8282/api/attendance/findAllAttendance');
  }


  getMonthlyAttendanceList(empId: number,year:number,month:string):Observable<any> {
    return this.httpClient.get('http://localhost:8282/api/attendance/monthlyAttendance/'+empId+'/'+year+'/'+month);
  }

  updateAttendance(id: number, value: any): Observable<Object> {
    return this.httpClient.put('http://localhost:8282/api/attendance/updateAttendance/'+id, value);
  }

  deleteAttendance(id: number): Observable<any> {
    return this.httpClient.delete('http://localhost:8282/api/attendance/deleteAttendance/'+id, { responseType: 'text' });
  }
}
