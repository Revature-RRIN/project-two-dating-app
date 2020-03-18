import { Injectable } from "@angular/core";
import { UrlService } from '../url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Users } from '../classes/users';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Currentuser } from '../classes/currentuser';


@Injectable()
export class ProfileService {
    private appUrl  = this.url.getUrl() + 'createprofile';
    private headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });
    private user: Users;  

    constructor(
        private url: UrlService,
        private http: HttpClient
    ) {}

    getProfile(id: number): Observable<Users> {
      const url: string = this.appUrl + '/' + id;
      return this.http.get(url, {withCredentials: true}).pipe(
        map(resp => resp as Users)
      );
    }
  

    updateProfile(user: Users): Observable<Users> {
      const body = JSON.stringify(user);
      if (user.usersId) {
        const url = this.appUrl + '/' + user.usersId;
        return this.http.put(url, body,
          {headers: this.headers, withCredentials: true}).pipe(
            map(resp => resp as Users)
          );
      } else {
        return this.http.post(this.appUrl, body,
          { headers: this.headers, withCredentials: true}).pipe(
            map(resp => resp as Users)
        );
      }
    }

}