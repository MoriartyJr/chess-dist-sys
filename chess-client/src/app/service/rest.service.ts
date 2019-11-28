import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { throwError as observableThrowError, Observable} from 'rxjs';
import { catchError } from 'rxjs/operators';

import { environment } from '../../environments/environment';


@Injectable()
export class RestService {
  public constructor( private readonly httpClient: HttpClient) {}

  public Get<TResult>(apiSuffix: string, request: any): Observable<TResult> {
    const url = this.BuildRoute(apiSuffix);
    const options = {
      params: request,
      withCredentials: false
    }

    var getResult = this.httpClient
      .get<TResult>(url, options)
      .pipe(catchError(response => this.HandleError(response)));
    
    return getResult;
  }

  public Post<TResult>(apiSuffix: string, request: any): Observable<TResult> {
    const url = this.BuildRoute(apiSuffix);
    const options = {
      withCredentials: true
    };

    return this.httpClient
      .post<TResult>(url, request, options)
      .pipe(
        catchError(response => this.HandleError(response))
      )
  }

  private BuildRoute(apiSuffix: string): string {
    return apiSuffix.startsWith("/")
      ? environment.apiRoute + apiSuffix
      : environment.apiRoute + "/" + apiSuffix;
  }

  private HandleError(response: Response) {
    console.log(response);
    return observableThrowError(response || "Server error");
  }
}
