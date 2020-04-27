import { AuthService } from '../auth.service';
import { RegisterPayload } from './../register-payload';
import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, FormControl, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  alert: boolean= false

  registerForm: FormGroup;
  registerPayload: RegisterPayload;

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private router: Router) {
   // this.registerForm = this.formBuilder.group({
      // username: '',
      // password: '',
      // confirmPassword: '',

    this.registerForm = new FormGroup({
      username: new FormControl('',Validators.required),
      password: new FormControl('',[Validators.required,Validators.minLength(6)]),
      confirmPassword: new FormControl('',[Validators.required,Validators.minLength(6)])
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
        console.log(' register successed!')

      this.router.navigateByUrl('/register-success');

    }, error => {
      console.log('register failed !');
    });
 //   alert: boolean= true
  }

  signin(){
    this.router.navigate(['sign_in']);
  }

}
