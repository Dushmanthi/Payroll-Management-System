import { Component, OnInit } from '@angular/core';
import {AddAttendanceService} from '../add-attendance.service';
import {Attendance} from './attendance';
import { Router } from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-add-attendance',
  templateUrl: './add-attendance.component.html',
  styleUrls: ['./add-attendance.component.css']
})
export class AddAttendanceComponent implements OnInit {
  form = new FormGroup({
    empId: new FormControl(0,Validators.required),
    year : new FormControl(0,Validators.required),
    month:new FormControl('',Validators.required),
    day : new FormControl(0,Validators.required),
    workingHours: new FormControl(0,Validators.required),
    isPresent : new FormControl('',Validators.required)
  });


  attendances: Observable<Attendance[]>;
attendance: Attendance= new Attendance();
submitted = false;

  constructor(private attendanceService: AddAttendanceService, private router: Router) {

  }

  ngOnInit() {
  }

  newAtttendance():void{
    this.submitted = false;
    this.attendance = new Attendance();
  }

  save(){
  this.attendanceService.addAttendance(this.attendance)
    .subscribe(data=>console.log(data),
    error=>console.log(error));
    this.attendance = new Attendance();

    this.gotoList();
  }

  onSubmit() {
      this.submitted = true;
      this.save();
    }

    gotoList() {

      this.router.navigate(['/view-attendance']);
      }

}
