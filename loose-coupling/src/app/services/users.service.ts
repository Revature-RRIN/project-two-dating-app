import { Injectable } from '@angular/core';
import { UrlService } from '../services/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Users } from '../classes/users';
import { Currentuser } from '../classes/currentuser';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class UsersService {
  private appUrl  = this.url.getUrl() + 'login';
  private headers = new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded'
  });
  private users: Users;
  
  constructor(
    private url: UrlService,
    private http: HttpClient
  ) { }

  login(username: string, password: string): Observable<Currentuser> {
    if (username && password) {
      
      // we are attempting to log in
      const body = `user=${username}&pass=${password}`;
      return this.http.post(this.appUrl, body, {
        headers: this.headers,
        withCredentials: true
      }).pipe(
        map(resp => {
          const user: Currentuser = resp as Currentuser;
          if (user) {
            this.users = user.users;
          }
          return user;
        })
      );
    } else {
      // checking to see if we're logged in
      return this.http.get(this.appUrl, {withCredentials: true}).pipe(
        map( resp => {
          const user: Currentuser = resp as Currentuser;
         
          console.log(user);  
          return user;
        })
      );
    }
  }
  logout(): Observable<object> {
    return this.http.delete(this.appUrl, {withCredentials: true}).pipe(
      map(success => {
        this.users = null;
        return success;
      })
    );
  }  
 
  getUser(): Users {
    return this.users;
  }

  //Maybe use below code for isAdmin or isMatchseeker?
  /*isEmployee(): boolean {
    return (this.employee !== undefined && this.employee !== null);
  }
  isCustomer(): boolean {
    return (this.customer !== undefined && this.customer !== null);
  }*/

 

  }



