import { Component, OnInit ,Input} from '@angular/core';
import {AddAttendanceService} from '../add-attendance.service';
import { Router, ActivatedRoute } from '@angular/router';
import {Attendance} from '../add-attendance/attendance';
import {ViewAttendanceComponent} from '../view-attendance/view-attendance.component';

@Component({
  selector: 'app-attendance-details',
  templateUrl: './attendance-details.component.html',
  styleUrls: ['./attendance-details.component.css']
})
export class AttendanceDetailsComponent implements OnInit {
   empId : number;
   attendance : Attendance;
  constructor(private route: ActivatedRoute,private router: Router, private attendanceService : AddAttendanceService) { }

  ngOnInit() {
    this.attendance = new Attendance();
    this.empId = this.route.snapshot.params['empId'];

    this.attendanceService.getAttendance(this.empId)
      .subscribe(data => {
        console.log(data)
        this.attendance = data;
      }, error => console.log(error));
  }

list(){
  this.router.navigate(['add-attendance']);
}

}
