import { Injectable } from '@angular/core';
import { UrlService } from 'src/app/shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private appUrl  = this.url.getUrl() + 'usermessages';
  private headers = new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded'
  });  

  constructor(
      private url: UrlService,
      private http: HttpClient
  ) {}

  sendMessage() {
    
  }

}
