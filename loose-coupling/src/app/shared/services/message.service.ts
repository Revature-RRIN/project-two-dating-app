import { Injectable, OnInit } from '@angular/core';
import { UrlService } from 'src/app/shared/url.service';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Messages } from '../classes/messages'
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Users } from '../classes/users';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private appUrl = this.url.getUrl() + 'messages';
  private headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(
    private url: UrlService,
    private http: HttpClient
  ) { }

  sendMessage(message: Messages): Observable<Messages> {
    console.log(message);
    const body = JSON.stringify(message);
    return this.http.post(this.appUrl, body,
      { headers: this.headers }).pipe(
        map(resp => resp as Messages));
  }

  idString: String;
  //get both the loggedin user, and the user that you are matched with
  viewMessages(users: Users, matchedUser: Users): Observable<Messages[]> {
    this.idString = "";
    this.idString = this.idString + users.usersId.toString();
    this.idString = this.idString + " ";
    this.idString = this.idString + matchedUser.usersId.toString();
    console.log("ids are: " + this.idString);
    return this.http.post(this.url.getUrl() + "displayMessages", this.idString, { headers: this.headers }).pipe(

      map(resp => {
        const messageList: Messages[] = resp as Messages[];
        console.log(messageList);
        return messageList;
      }));
  }


}


