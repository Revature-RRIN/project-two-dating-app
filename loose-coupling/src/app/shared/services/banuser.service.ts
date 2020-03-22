import { Injectable } from '@angular/core';
import { UrlService } from '../url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Users } from '../classes/users';
import { getMultipleValuesInSingleSelectionError } from '@angular/cdk/collections';

@Injectable({
  providedIn: 'root'
})
export class BanuserService {
  private appUrl  = this.url.getUrl() + 'users';
  private headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  users: Users;
  banned: Users;
  usArr: Users[];
  

  constructor(private url: UrlService,
    private http: HttpClient) { }

  deleteUser(users: Users): Observable<object> {
    console.log(users);
    const url = this.appUrl + '/' + users.usersId;
    
    return this.http.delete(url, {withCredentials: true}).pipe(
      map(success => {
        this.users = null;
        return success;
      }))

    }
    
  getAllUsers(): Observable<Users[]> {
    return this.http.get(this.appUrl, {headers: this.headers, withCredentials: true })
    .pipe(map(resp => resp as Users[]));
  }
}
