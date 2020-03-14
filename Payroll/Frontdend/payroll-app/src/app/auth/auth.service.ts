import { Observable } from 'rxjs';
import { RegisterPayload } from './register-payload';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private url = 'http://localhost:8484/api/auth/';

  constructor(private httpClient: HttpClient) { }

  register(registerPayload: RegisterPayload): Observable<any>  {
    return this.httpClient.post(this.url + 'signup', registerPayload);
  }
}
