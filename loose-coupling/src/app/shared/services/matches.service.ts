import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { UrlService } from "../url.service";
import { Observable } from "rxjs";
import { Matches } from "../classes/matches";
import { map } from "rxjs/operators";

@Injectable()
export class MatchesService {
  private appUrl = this.url.getUrl() + "matches";
  private headers = new HttpHeaders({
    "Content-Type": "application/json"
  });

  constructor(private url: UrlService, private http: HttpClient) {}

  getMatches(): Observable<Matches[]> {
    return this.http
      .get(this.appUrl, { headers: this.headers, withCredentials: true })
      .pipe(map(resp => resp as Matches[]));
  }

  /*signup(users: Users): Observable<Users> {
    const body = JSON.stringify(users);
    return this.http
      .post(this.appUrl, body, { headers: this.headers, withCredentials: true })
      .pipe(map(resp => resp as Users));
  }*/
}
