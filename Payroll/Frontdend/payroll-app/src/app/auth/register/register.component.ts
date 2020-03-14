import { AuthService } from '../auth.service';
import { RegisterPayload } from './../register-payload';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  registerPayload: RegisterPayload;

  constructor(private formBuilder: FormBuilder, private authService: AuthService) {
    this.registerForm = this.formBuilder.group({
      username: '',
      password: '',
      confirmPassword: '',
    });
    this.registerPayload = {
      username: '',
      password: '',
      confirmPassword: '',
    };

   }


  ngOnInit() {
  }

  signup() {
    this.registerPayload.username = this.registerForm.get('username').value;
    this.registerPayload.password = this.registerForm.get('password').value;
    this.registerPayload.confirmPassword = this.registerForm.get('confirmPassword').value;

    this.authService.register(this.registerPayload).subscribe(data => {
        console.log(' register successed!');
    }, error => {
      console.log('failed !');
    });
  }

}
