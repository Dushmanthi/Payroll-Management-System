import { Component, OnInit } from '@angular/core';
import {Attendance} from '../add-attendance/attendance';
import {ActivatedRoute, Router} from '@angular/router';
import {AddAttendanceService} from '../add-attendance.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-monthly-attendance',
  templateUrl: './monthly-attendance.component.html',
  styleUrls: ['./monthly-attendance.component.css']
})
export class MonthlyAttendanceComponent implements OnInit {
  form = new FormGroup({
    empId: new FormControl(0,Validators.required),
    year : new FormControl(0,Validators.required),
    month:new FormControl('',Validators.required)
  });

  empId : number;
  year: number;
  month: string;

  attendance: Attendance= new Attendance();
  attendances: Observable<Attendance[]>;
  constructor(private route: ActivatedRoute,private router: Router, private attendanceService : AddAttendanceService) { }

  ngOnInit() {

  }


  onSubmit() {
    this.attendance = new Attendance();

    this.empId = this.form.get('empId').value;
    this.year = this.form.get('year').value;
    this.month = this.form.get('month').value;
    console.log(this.empId);
    console.log(this.year);
    console.log(this.month);
     this.attendanceService.getMonthlyAttendanceList(this.empId,this.year,this.month)
      .subscribe(data => {
        console.log(data)
        this.attendance = data;
      }, error => console.log(error));
    this.reloadData();
  }

  reloadData(){
    this.attendances = this.attendanceService.getMonthlyAttendanceList(this.empId,this.year,this.month);
  }

  list(){
    this.router.navigate(['view-attendance']);
  }

}
