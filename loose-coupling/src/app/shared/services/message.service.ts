import { Injectable } from '@angular/core';
import { UrlService } from 'src/app/shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Messages } from '../classes/messages'
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private appUrl  = this.url.getUrl() + 'usermessages';
  private headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });  

  constructor(
      private url: UrlService,
      private http: HttpClient
  ) {}

  viewMessages()  {

  }
  
  sendMessage(remark:Messages):Observable<Messages> {
    const body = JSON.stringify(remark);
    return this.http.post(this.appUrl, body,
      {headers: this.headers, withCredentials: true}).pipe(
        map( resp => resp as Messages ));
  }

}
