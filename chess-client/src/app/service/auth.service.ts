import { Injectable } from '@angular/core';
import { RestService } from './rest.service';
import { Observable } from 'rxjs';
import { Login } from '../models/login';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public constructor(
    private readonly restService: RestService
  ) { }

  public GetUserDetails(login: Login): Observable<User> {
    return this.restService.Post<User>("API/Login", login);
  }

  public PostRegist(user: User): Observable<boolean> {
    return this.restService.Post<boolean>("API/Regist", user);
  }
}
