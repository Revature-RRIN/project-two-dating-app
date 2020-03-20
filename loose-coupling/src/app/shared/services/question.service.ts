import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from '../url.service';
import { Questions } from '../classes/questions';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable()
export class QuestionService {
  private appUrl  = this.url.getUrl() + 'questions';
  private headers = new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded'
  });

  constructor(
    private url: UrlService,
    private http: HttpClient
    ) { }

    getQuestions(): Observable<Questions[]> {
      // withCredentials enables the sending of cookies.
      return this.http.get(this.appUrl, {headers: this.headers,withCredentials: true} ).pipe(
        map( resp => resp as Questions[] )
      );
    }
}
