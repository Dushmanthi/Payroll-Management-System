import { Component, OnInit } from '@angular/core';
import {Attendance} from '../add-attendance/attendance';
import {AddAttendanceService} from '../add-attendance.service';
import {Router} from '@angular/router';
import { Observable } from "rxjs";

@Component({
  selector: 'app-view-attendance',
  templateUrl: './view-attendance.component.html',
  styleUrls: ['./view-attendance.component.css']
})
export class ViewAttendanceComponent implements OnInit {
 attendances: Observable<Attendance[]>;

  constructor(private attendanceService:AddAttendanceService, private router:Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.attendances = this.attendanceService.getAttendanceList();
  }

  deleteAttendance(id:number){
    this.attendanceService.deleteAttendance(id)
      .subscribe(data=>{
        console.log(data);
        this.reloadData();
      },
        error=>{
        console.log(error);
        });
  }

  attendanceDetails(id:number){
    this.router.navigate(['attendance-details',id]);
  }

  updateAttendance(id: number){
    this.router.navigate(['update-attendance', id]);
  }

   addAttendance(){
    this.router.navigate(['add-attendance']);
  }

  viewMonthlyAttendance(){
    this.router.navigate(['monthly-attendance']);
  }



}
