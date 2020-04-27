import { Component, OnInit } from '@angular/core';
import {Attendance} from '../add-attendance/attendance';
import {AddAttendanceService} from '../add-attendance.service';
import { ActivatedRoute, Router } from '@angular/router';
import {Observable} from 'rxjs';
import {Payment} from '../add-payment/payment';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-update-attendance',
  templateUrl: './update-attendance.component.html',
  styleUrls: ['./update-attendance.component.css']
})
export class UpdateAttendanceComponent implements OnInit {
  form = new FormGroup({
    empId: new FormControl(0,Validators.required),
    year : new FormControl(0,Validators.required),
    month:new FormControl('',Validators.required),
    day : new FormControl(0,Validators.required),
    workingHours: new FormControl(0,Validators.required),
    isPresent : new FormControl('',Validators.required)
  });

    empId: number;
    attendance : Attendance;
  attendances: Observable<Attendance[]>;
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
    this.attendances = this.attendanceService.getAttendanceList();
    this.router.navigate(['view-attendance']);
  }



}
