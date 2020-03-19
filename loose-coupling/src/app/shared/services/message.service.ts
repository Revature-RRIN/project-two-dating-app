import { Injectable, OnInit } from '@angular/core';
import { UrlService } from 'src/app/shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Messages } from '../classes/messages'
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Currentuser } from '../classes/currentuser';
import { Users } from '../classes/users';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private appUrl = this.url.getUrl() + 'usermessages';
  private headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(
    private url: UrlService,
    private http: HttpClient
  ) { }

  sendMessage(message: Messages): Observable<Messages> {
    const body = JSON.stringify(message);
    return this.http.post(this.appUrl, body,
      { headers: this.headers }).pipe(
        map(resp => resp as Messages));
  }



  viewMessages(users:Users): Observable<Messages>  {
const body = JSON.stringify(users);
    return this.http.get(this.appUrl, {headers: this.headers}).pipe(
      map(resp => {
        const message: Messages = resp as Messages;
        return message;
      }));
      }
  }
  
