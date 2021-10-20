import { environment } from '../../../../environments/environment';
import { Usuario } from '../../../model/usuario.model';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  urlBase: string =`${environment.BASE_URL}/auth`;
  private usuarioAutenticado: boolean = false;

  constructor(private http: HttpClient) {}

  auth(usuario: Usuario): Observable<boolean> {
    return this.http.post<boolean>(this.urlBase, usuario);
  }

  setUsuarioAutenticado(usuarioAutenticado: boolean) {
    this.usuarioAutenticado = usuarioAutenticado;
  }

  usuarioEstaAutenticado(): boolean {
    return  this.usuarioAutenticado;
  }
}
