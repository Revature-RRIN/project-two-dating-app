import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from '../url.service';
import { Answers } from '../answers';
import { Questions } from '../questions';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';


@Injectable()
export class UploadResponsesService {
  private appUrl = this.urlService.getUrl() + 'books';
  private headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });
  constructor(
    private urlService: UrlService,
    private http: HttpClient
    ) { }

    getAnswers(): Observable<Answers[]> {
        return this.http.get(this.appUrl, {withCredentials: true} ).pipe(
            map( resp => resp as Answers[] )
          );      
    }
    getAnswer(whichQuestionId: number): Observable<Answers> {
        const url: string = this.appUrl + '/' + whichQuestionId;
        return this.http.get(url, {withCredentials: true}).pipe(
          map(resp => resp as Answers) //does this line work? Does 'as Answers' specify which question is being answered?
        );
      }
      updateAnswers(answers: Answers): Observable<Answers> {
        const body = JSON.stringify(answers);
        if (answers.answersId) {
          const url = this.appUrl + '/' + answers.answersId;
          return this.http.put(url, body,
            {headers: this.headers, withCredentials: true}).pipe(
              map(resp => resp as Answers)
            );
        } else {
            return this.http.post(this.appUrl, body,
              { headers: this.headers, withCredentials: true}).pipe(
                map(resp => resp as Answers)
            );
          }
        }
}
