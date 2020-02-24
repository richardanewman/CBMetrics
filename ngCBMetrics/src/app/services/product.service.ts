import { Injectable } from '@angular/core';
import { Product } from '../models/product';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + 'api/';

  constructor(
    private auth: AuthService,
    private router: Router,
    private http: HttpClient
  ) { }

  index() {
    const credentials = this.auth.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Product[]>(this.url + 'products', httpOptions).pipe(
    catchError((err: any) => {
      console.error(err);
      return throwError('ProductService.index(): Error getting all products');
    })
    );
  }

}
