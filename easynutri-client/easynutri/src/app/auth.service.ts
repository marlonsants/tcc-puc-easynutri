import { environment } from '../environments/environment';
import { Usuario } from './model/usuario.model';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { CookieServiceService } from './cookie-service.service';
import { Router } from '@angular/router';

const keyNameCookieUsuarioLogado = 'usuarioLogado';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  urlBase: string =`${environment.BASE_URL}/auth`;

  constructor(
    private http: HttpClient,
    private cookieService: CookieServiceService,
    private router: Router) {}

  auth(usuario: Usuario): Observable<boolean> {
    return this.http.post<boolean>(this.urlBase, usuario)
    .pipe(
      map(autenticado => {

        if (autenticado) {
          this.setUsuarioLogado(usuario);
        }
        return autenticado;
      })
    );
  }

  usuarioEstaAutenticado(): boolean {
    let usuarioLogado = this.getUsuarioLogado();
    return  usuarioLogado != undefined;
  }

  setUsuarioLogado(usuario: Usuario) {
    if (usuario != undefined) {
      usuario.senha = undefined;
    }
    this.cookieService.setCookie(keyNameCookieUsuarioLogado,usuario,1);
  }

  getUsuarioLogado() {
    return this.cookieService.getCookie(keyNameCookieUsuarioLogado);
  }

  logout() {
    this.cookieService.deleteCookie(keyNameCookieUsuarioLogado);
    this.router.navigate(['login']);
  }
}
