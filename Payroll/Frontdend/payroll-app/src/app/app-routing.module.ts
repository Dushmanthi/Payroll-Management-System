import { LogoutComponent } from './logout/logout.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './auth/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegisterComponent} from './auth/register/register.component';
import {RegisterSuccessComponent} from './auth/register-success/register-success.component';
import {Ng2Webstorage} from 'ngx-webstorage';


const routes: Routes = [
  {path: 'login', component: LoginComponent, pathMatch: 'full'},
  {path: '', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'signup', component: RegisterComponent},
  {path: 'register-success', component: RegisterSuccessComponent},
  // {path:'registration',component:RegistrationComponent},
  {path: 'logout', component: LogoutComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes), Ng2Webstorage.forRoot()],
  exports: [RouterModule]
})
export class AppRoutingModule { }
