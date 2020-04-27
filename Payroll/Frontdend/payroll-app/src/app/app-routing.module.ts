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
import {MonthlyAttendanceComponent} from './monthly-attendance/monthly-attendance.component';
import {MonthlyPaymentComponent} from './monthly-payment/monthly-payment.component';
import {MonthlySalaryComponent} from './monthly-salary/monthly-salary.component';
import {AuthGuard} from './auth.guard';

const routes: Routes = [
  {path: 'sign_in', component: LoginComponent, pathMatch: 'full'},
  {path: '', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'sign_up', component: RegisterComponent},
  {path: 'register-success', component: RegisterSuccessComponent},

  {path:'add-attendance',component:AddAttendanceComponent,canActivate:[AuthGuard]},
  {path:'view-attendance',component:ViewAttendanceComponent},
  {path:'attendance-details/:empId',component:AttendanceDetailsComponent},
  {path:'update-attendance/:empId',component:UpdateAttendanceComponent},
  {path:'monthly-attendance',component:MonthlyAttendanceComponent},

  {path:'add-payment',component:AddPaymentComponent},
  {path:'view-payment',component:ViewPaymentsComponent},
  {path:'payment-details/:empId',component:PaymentDetailsComponent},
  {path:'update-payment/:empId',component:UpdatePaymentsComponent},
  {path:'monthly-payment',component:MonthlyPaymentComponent},
  {path:'monthly-salary',component:MonthlySalaryComponent},

  {path:'add-employee',component:AddEmployeeComponent},
  {path:'view-employee',component:ViewEmployeesComponent},
  {path:'employee-details/:empId',component:EmployeeDetailsComponent},
  {path:'update-employee/:empId',component:UpdateEmployeeComponent,canActivate:[AuthGuard]},

  {path: 'sign_out', component: LogoutComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes), Ng2Webstorage.forRoot()],
  exports: [RouterModule]
})
export class AppRoutingModule { }
