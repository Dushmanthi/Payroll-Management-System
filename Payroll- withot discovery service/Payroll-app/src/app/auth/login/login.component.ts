import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {LoginPayload} from '../login-payload';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loginPayload: LoginPayload;

  constructor(private authService: AuthService, private router: Router) {
    this.loginForm = new FormGroup({
        username: new FormControl('',Validators.required),
        password: new FormControl('',[Validators.required,Validators.minLength(6)])

      }
    );
    this.loginPayload = {
    username: '',
    password: ''
  };
  }

ngOnInit() {
  }

signin() {
  this.loginPayload.username = this.loginForm.get('username').value;
  this.loginPayload.password = this.loginForm.get('password').value;

  this.authService.signin(this.loginPayload).subscribe(data => {
    if (data) {
      console.log('login success');
      this.router.navigateByUrl('/dashboard');
    } else {
      console.log('login failed');
    }
  });
}

  signup(){
    this.router.navigate(['sign_up']);
  }

}
