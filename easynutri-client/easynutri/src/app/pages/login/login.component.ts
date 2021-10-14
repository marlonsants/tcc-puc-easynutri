import { LoginService } from './shared/login.service';
import { Component, OnInit } from '@angular/core';

import { GoogleLoginProvider, SocialAuthService, SocialUser } from 'angularx-social-login';
import { Usuario } from './../../model/usuario.model';

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
    private loginService: LoginService
    ) { }

  ngOnInit(): void {

    this.socialAuthService.authState.subscribe((user) => {
      this.socialUser = user;
      this.isLoggedin = (user != null);
    });

  }

  login() {
    this.loginService.login(this.usuario).subscribe((logado: boolean) => {
      console.log(logado);
    })
  }

  loginWithGoogle(): void {
    this.socialAuthService.signIn(GoogleLoginProvider.PROVIDER_ID);
  }

  logOut(): void {
    this.socialAuthService.signOut(true);
  }

}
