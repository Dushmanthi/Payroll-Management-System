import { LogoutComponent } from './logout/logout.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './auth/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegisterComponent} from './auth/register/register.component';
import {RegisterSuccessComponent} from './auth/register-success/register-success.component';
import {Ng2Webstorage} from 'ngx-webstorage';
import { AddAttendanceComponent } from './add-attendance/add-attendance.component';
import {AddPaymentComponent} from './add-payment/add-payment.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import {ViewAttendanceComponent} from './view-attendance/view-attendance.component';
import {AttendanceDetailsComponent} from './attendance-details/attendance-details.component';
import {UpdateAttendanceComponent} from './update-attendance/update-attendance.component';
import {ViewPaymentsComponent} from './view-payments/view-payments.component';
import {PaymentDetailsComponent} from './payment-details/payment-details.component';
import {UpdatePaymentsComponent} from './update-payments/update-payments.component';
import {ViewEmployeesComponent} from './view-employees/view-employees.component';
import {EmployeeDetailsComponent} from './employee-details/employee-details.component';
import {UpdateEmployeeComponent} from './update-employee/update-employee.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent, pathMatch: 'full'},
  {path: '', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'signup', component: RegisterComponent},
  {path: 'register-success', component: RegisterSuccessComponent},

  {path:'add-attendance',component:AddAttendanceComponent},
  {path:'view-attendance',component:ViewAttendanceComponent},
  {path:'attendance-details/:empId',component:AttendanceDetailsComponent},
  {path:'update-attendance/:empId',component:UpdateAttendanceComponent},

  {path:'add-payment',component:AddPaymentComponent},
  {path:'view-payment',component:ViewPaymentsComponent},
  {path:'payment-details/:empId',component:PaymentDetailsComponent},
  {path:'update-payment/:empId',component:UpdatePaymentsComponent},

  {path:'add-employee',component:AddEmployeeComponent},
  {path:'view-employee',component:ViewEmployeesComponent},
  {path:'employee-details/:empId',component:EmployeeDetailsComponent},
  {path:'update-employee/:empId',component:UpdateEmployeeComponent},

  {path: 'logout', component: LogoutComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes), Ng2Webstorage.forRoot()],
  exports: [RouterModule]
})
export class AppRoutingModule { }
