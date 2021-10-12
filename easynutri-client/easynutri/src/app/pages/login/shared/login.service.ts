import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  urlBase: string = 'localhost:8080/login';

  constructor(private http: HttpClient) {

  }

  login(): Observable<boolean> {
    return this.http.post<boolean>(this.urlBase,{});
  }
}
