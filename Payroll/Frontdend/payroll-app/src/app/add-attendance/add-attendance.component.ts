import { Component, OnInit } from '@angular/core';
import {AddAttendanceService} from '../add-attendance.service';
import {Attendance} from './attendance';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-attendance',
  templateUrl: './add-attendance.component.html',
  styleUrls: ['./add-attendance.component.css']
})
export class AddAttendanceComponent implements OnInit {
attendance: Attendance= new Attendance();
submitted = false;
// attendanceForm:FormGroup;
// attendancePayload :AttendancePayload;
//
// empId =new FormControl('');
// year =new FormControl('');
// month =new FormControl('');
// day =new FormControl('');
// workingHours =new FormControl('');
// isPresent =new FormControl('');

  constructor(private addAttendanceService: AddAttendanceService, private router: Router) {
//   this.attendanceForm = new FormGroup({
//   empId : this.empId,
//   year : this.year,
//   month: this.month,
//   day : this.day,
//   workingHours: this.workingHours,
//   isPresent : this.isPresent,

//   });
//
//   this.attendancePayload ={
//   empId : '',
//     year : '',
//     month:'',
//     day : '',
//     workingHours: '',
//     isPresent : '',
//
//   }

  }

  ngOnInit() {
  }

  newAtttendance():void{
    this.submitted = false;
    this.attendance = new Attendance();
  }

  save(){
  this.addAttendanceService.addAttendance(this.attendance)
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



//   addAttendance(){
//     this.attendancePayload.empId = this.attendanceForm.get('empId').value;
//     this.attendancePayload.year = this.attendanceForm.get('year').value;
//     this.attendancePayload.month = this.attendanceForm.get('month').value;
//     this.attendancePayload.day = this.attendanceForm.get('day').value;
//     this.attendancePayload.workingHours = this.attendanceForm.get('workingHours').value;
//     this.attendancePayload.isPresent = this.attendanceForm.get('isPresent').value;
//
//     this.addAttendanceService.addAttendance(this.attendancePayload).subscribe(data=>{
//             console.log('attendance added successfuly');
//             this.router.navigateByUrl('/attendance-details');
//         }, error => {
//           console.log('attendance failed');
//         });
//   }

}
