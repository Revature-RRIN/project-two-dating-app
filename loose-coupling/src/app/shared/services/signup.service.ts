import { Injectable } from '@angular/core';
import { Users } from '../classes/users';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from '../url.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()

export class SignupService {
  private appUrl  = this.url.getUrl() + 'signup';
  private headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });
  private users: Users;
  

  constructor(
    private url: UrlService,
    private http: HttpClient
  ) { }

  signup(users:Users):Observable<Users> {
    const body = JSON.stringify(users);
    return this.http.post(this.appUrl, body,
      {headers: this.headers, withCredentials: true}).pipe(
        map( resp => resp as Users ));

  }

}
