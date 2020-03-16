import { Injectable } from "@angular/core";
import { UrlService } from 'src/app/shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Users } from 'src/app/shared/classes/users';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Currentuser } from 'src/app/shared/classes/currentuser';

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

    //updating user information once they click the submit button
    submit (firstname: string, lastname: string, age: number,
         gender: number, location: string): Observable<Currentuser> {
             if (((firstname && lastname) && age) && (gender && location)) {
                const body = `firstname=${firstname}&lastname=${lastname}&
                    age=${age}&gender=${gender}&location=${location}`;
                return this.http.put(this.appUrl, body, {
                    headers: this.headers,
                    withCredentials: true
                  }).pipe(
                    map(resp => {
                      const user: Currentuser = resp as Currentuser;
                      if (user) {
                        this.user = user.user;
                      }
                      return user;
                    })
                  );
                
            }
    }

    // getUser(): Users {
    //     return this.user;
    // }
    // isUser(): boolean {
    //   return (this.user !== undefined && this.user !== null);
    // }
  
}