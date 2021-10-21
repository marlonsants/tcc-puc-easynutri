import { AuthService } from '../../auth.service';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

import { GoogleLoginProvider, SocialAuthService, SocialUser } from 'angularx-social-login';
import { Usuario } from './../../model/usuario.model';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {

  usuario: Usuario = {};

  constructor(
    private socialAuthService: SocialAuthService,
    private authService: AuthService,
    private router: Router,
    private messageService: MessageService
    ) { }


  ngOnInit(): void {

    this.socialAuthService.authState.subscribe((user) => {
      if (user != null) {
        let usuarioLocal: Usuario = {
          email: user.email
        }
        this.authService.setUsuarioLogado(usuarioLocal);
        this.router.navigate(['home']);
      }
    });

  }

  ngOnDestroy(): void {
    this.socialAuthService.signOut(true).catch(() => {});
  }

  login() {
    this.authService.auth(this.usuario).subscribe((autenticado: boolean) => {
      if (autenticado) {
        this.router.navigate(['home']);
      } else {
        this.messageService.add({severity: 'warn', detail: ''})
      }
    }
    );
  }

  loginWithGoogle(): void {
    this.socialAuthService.signIn(GoogleLoginProvider.PROVIDER_ID);
  }

  logOutWithGoogle(): void {
    this.socialAuthService.signOut(true).catch(() => {});
  }

}
