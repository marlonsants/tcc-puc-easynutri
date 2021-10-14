import { Usuario } from './../../../model/usuario.model';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  urlBase: string = 'http://localhost:8080/login';

  constructor(private http: HttpClient) {}

  login(usuario: Usuario): Observable<boolean> {
    return this.http.post<boolean>(this.urlBase, JSON.stringify(usuario));
  }
}
