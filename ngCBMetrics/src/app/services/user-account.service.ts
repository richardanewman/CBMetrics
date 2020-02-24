import { UserAccount } from './../models/user-account';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserAccountService {
// private baseUrl = environment.baseUrl;
private baseUrl = environment.baseUrl;
private url = this.baseUrl + 'api/';

constructor(private http: HttpClient, private authSvc: AuthService) {}

index() {
  const credentials = this.authSvc.getCredentials();
  // Send credentials as Authorization header (this is spring security convention for basic auth)
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest'
    })
  };

  return this.http
    .get<UserAccount[]>(this.url + 'users/?sorted=true', httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
}

getUserInSession() {
  const credentials = this.authSvc.getCredentials();
  const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest'
    })
  };

  return this.http.get<UserAccount>(this.url + 'user', httpOptions).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('Could not return User in Session');
    })
  );
}

delete(id: number) {
  const credentials = this.authSvc.getCredentials();
  // Send credentials as Authorization header (this is spring security convention for basic auth)
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest'
    })
  };

  return this.http.delete<UserAccount>(this.url + 'users/' + id, httpOptions).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('KABOOM');
    })
  );
}

show(id: string) {
  const credentials = this.authSvc.getCredentials();
  // Send credentials as Authorization header (this is spring security convention for basic auth)
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest'
    })
  };

  return this.http.get<UserAccount[]>(this.url + 'users/' + id, httpOptions).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('KABOOM');
    })
  );
}

update(user: UserAccount, id: number) {
  const credentials = this.authSvc.getCredentials();
  // Send credentials as Authorization header (this is spring security convention for basic auth)
  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest',
      'Content-Type': 'application/json'
    })
  };

  return this.http
    .put<UserAccount>(this.url + 'users/' + id, user, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
}

create(newUser: UserAccount) {
  const credentials = this.authSvc.getCredentials();
  // Send credentials as Authorization header (this is spring security convention for basic auth)

  const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest',
      'Content-Type': 'application/json'
    })
  };

  return this.http.post<UserAccount>(this.url, newUser, httpOptions).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('KABOOM');
    })
  );
}
}
