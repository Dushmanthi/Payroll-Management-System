import { Component, OnInit } from '@angular/core';
// import { Message } from '../message';
// import { DashboardMessageService } from '../dashboard-message.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  message: string;
  dashboardService: any;

  constructor(
  //  private dashboardComponent:DashboardMessageService
  ) { }

  ngOnInit() {
    // console.log("DashboardMessageComponent");
    // this.dashboardService.dashboardService().subscribe( (result) => {
    //   this.message = result.content;
    // });
  }

}
