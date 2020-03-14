import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  model:RegistrationForm={
  empId:'',
  firstName: '',
  lastName:'',
  number:'',
  street:'',
  city:'',
  phoneNumber:'',
  email:'',
  password:'',
  designation:'',
  hourlypay:'',
  maximumWorkingHours:''
  }
  constructor(private http:HttpClient) { }

  ngOnInit() {
  }

  saveEmployee(): void{
   // alert(this.model.empId);
   let url="http://localhost:8181/payroll/registration";
   this.http.post(url,this.model).subscribe(
    res => {
      location.reload();
    },
    err => {
      alert("An error has occured")
    }
    

   );
  }

}

export interface RegistrationForm{
  empId:string;
  firstName: string;
  lastName:string;
  number:string;
  street:string;
  city:string;
  phoneNumber:string;
  email:string;
  password:string;
  designation:string;
  hourlypay:string;
  maximumWorkingHours:string;
    // private String state;
}
