import { AuthService } from './shared/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { GoogleLoginProvider, SocialAuthService, SocialUser } from 'angularx-social-login';
import { Usuario } from './../../model/usuario.model';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  socialUser!: SocialUser;
  isLoggedin: boolean = false;
  usuario: Usuario = {};

  constructor(
    private socialAuthService: SocialAuthService,
    private authService: AuthService,
    private router: Router,
    private messageService: MessageService
    ) { }

  ngOnInit(): void {

    this.socialAuthService.authState.subscribe((user) => {
      this.socialUser = user;
      this.isLoggedin = (user != null);
    });

  }

  login() {
    this.authService.auth(this.usuario).subscribe((autenticado: boolean) => {
      this.authService.setUsuarioAutenticado(autenticado);
      if (autenticado) {
        this.router.navigate(['home']);
      } else {
        this.messageService.add({severity: 'warn', detail: ''})
      }


    })
  }

  loginWithGoogle(): void {
    this.socialAuthService.signIn(GoogleLoginProvider.PROVIDER_ID);
  }

  logOut(): void {
    this.socialAuthService.signOut(true);
  }

}
