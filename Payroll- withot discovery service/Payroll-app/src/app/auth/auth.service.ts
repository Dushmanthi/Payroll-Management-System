import { Observable } from 'rxjs';
import { RegisterPayload } from './register-payload';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {LoginPayload} from './login-payload';
import {map} from 'rxjs/operators';
import {JwtAutResponse} from './jwt-auth-response';
import {LocalStorageService} from 'ngx-webstorage';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private url = 'http://localhost:8484/api/auth/';

  constructor(private httpClient: HttpClient, private localStoraqeService: LocalStorageService) { }

  register(registerPayload: RegisterPayload): Observable<any>  {
    return this.httpClient.post(this.url + 'signup', registerPayload);
  }

  signin(loginPayload: LoginPayload): Observable<boolean> {
    return this.httpClient.post<JwtAutResponse>(this.url + 'login', loginPayload).pipe(map(data => {
      this.localStoraqeService.store('authenticationToken', data.authenticationToken);
      this.localStoraqeService.store('username', data.username);
      return true;
    }));
  }
  isAuthenticated():Boolean{
    return this.localStoraqeService.retrieve('username') !=null;
  }

  signout(){
    this.localStoraqeService.clear('authenticationToken');
    this.localStoraqeService.clear('username');
  }

}
