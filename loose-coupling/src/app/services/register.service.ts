import { Injectable } from '@angular/core';
import { UrlService } from '../services/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Users } from '../Classes/users';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Currentuser } from '../Classes/currentuser';

@Injectable()
export class RegisterService {
  private appUrl = this.url.getUrl() + 'registeraccount';
  private headers = new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded'
  });
  private user: Users;

  constructor(
    private url: UrlService,
    private http: HttpClient
  ) { }

  submit(newUsername: string, newPassword: string): Observable<Currentuser> {
    if (newUsername && newPassword) {
      const body = `username=${newUsername}&pass=${newPassword}`;
      return this.http.put(this.appUrl, body, {
        headers: this.headers,
        withCredentials: true
      }).pipe(
        map(resp => {
          const user: Currentuser = resp as Currentuser;
          if (user) {
            this.user = user.users;
          }
          return user;
        })
      );

    }
  }

}