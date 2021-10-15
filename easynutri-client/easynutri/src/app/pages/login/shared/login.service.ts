import { environment } from './../../../../environments/environment';
import { Usuario } from './../../../model/usuario.model';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  urlBase: string =`${environment.BASE_URL}/login`;

  constructor(private http: HttpClient) {}

  login(usuario: Usuario): Observable<boolean> {
    return this.http.post<boolean>(this.urlBase, usuario);
  }
}
