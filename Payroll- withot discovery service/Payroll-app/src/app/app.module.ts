import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LogoutComponent } from './logout/logout.component';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { MenuComponent } from './menu/menu.component';
import { RegisterComponent } from './auth/register/register.component';
import { RegisterSuccessComponent } from './auth/register-success/register-success.component';
import {Ng2Webstorage} from 'ngx-webstorage';
import { AddAttendanceComponent } from './add-attendance/add-attendance.component';
import { AddPaymentComponent } from './add-payment/add-payment.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ViewEmployeesComponent } from './view-employees/view-employees.component';
import { ViewAttendanceComponent } from './view-attendance/view-attendance.component';
import { ViewPaymentsComponent } from './view-payments/view-payments.component';
import { AttendanceDetailsComponent } from './attendance-details/attendance-details.component';
import { UpdateAttendanceComponent } from './update-attendance/update-attendance.component';
import { UpdatePaymentsComponent } from './update-payments/update-payments.component';
import { PaymentDetailsComponent } from './payment-details/payment-details.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    LogoutComponent,
    MenuComponent,
    RegisterComponent,
    RegisterSuccessComponent,
    AddAttendanceComponent,
    AddPaymentComponent,
    AddEmployeeComponent,
    ViewEmployeesComponent,
    ViewAttendanceComponent,
    ViewPaymentsComponent,
    AttendanceDetailsComponent,
    UpdateAttendanceComponent,
    UpdatePaymentsComponent,
    PaymentDetailsComponent,
    UpdateEmployeeComponent,
    EmployeeDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2Webstorage
  ],
  providers: [
   // {
     // provide: HTTP_INTERCEPTORS,
      // useClass: HttpInterceptorService,
    //  multi: true
    // }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
