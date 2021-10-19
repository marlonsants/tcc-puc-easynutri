import { Observable } from 'rxjs';
import { environment } from './../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Usuario } from './../../../model/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  urlBase: string =`${environment.BASE_URL}/usuario`;

  cadastrar(usuario: Usuario): Observable<boolean> {
    return this.http.post<boolean>(this.urlBase, usuario);
  }
}
