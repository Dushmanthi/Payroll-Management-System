import { Component, OnInit } from '@angular/core';
import {Attendance} from '../add-attendance/attendance';
import {AddAttendanceService} from '../add-attendance.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-attendance',
  templateUrl: './update-attendance.component.html',
  styleUrls: ['./update-attendance.component.css']
})
export class UpdateAttendanceComponent implements OnInit {
    empId: number;
    attendance : Attendance;
  constructor(private route: ActivatedRoute,private router: Router,private attendanceService: AddAttendanceService) { }

  ngOnInit() {
    this.attendance = new Attendance();
    this.empId = this.route.snapshot.params['empId'];
    this.attendanceService.getAttendance(this.empId)
      .subscribe(data=>{
        console.log(data);
        this.attendance = data;
      },error => console.log(error));
  }

  updateAttendance(){
    console.log("data update stated");
  this.attendanceService.updateAttendance(this.empId,this.attendance)
    .subscribe(data=>console.log(data),
      error=>console.log(error));
    this.attendance = new Attendance();
    this.gotoList();
  }

  onSubmit() {
    console.log("click update");
    this.updateAttendance();
  }

  gotoList() {
    console.log("navigate update");
    this.router.navigate(['view-attendance']);
  }



}
