import { RegistrationComponent } from './registration/registration.component';
import { LogoutComponent } from './logout/logout.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegisterComponent} from './auth/register/register.component';


const routes: Routes = [
  {path:'login',component:LoginComponent,pathMatch:'full'},
  {path:'',component:LoginComponent},
  {path:'dashboard',component:DashboardComponent},
  {path:'signup',component:RegisterComponent},
  // {path:'registration',component:RegistrationComponent},
  {path:'logout',component:LogoutComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
