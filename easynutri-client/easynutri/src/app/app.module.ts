import { HomeModule } from './pages/home/shared/home.module';
import { LoginModule } from './pages/login/shared/login.module';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LOCALE_ID, NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';

import { SocialLoginModule, SocialAuthServiceConfig } from 'angularx-social-login';
import { GoogleLoginProvider } from 'angularx-social-login';
import {ToastModule} from 'primeng/toast';
import { RippleModule } from 'primeng/ripple';

import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { CadastroUsuarioModule } from './pages/cadastro-usuario/cadastro-usuario.module';
import { DadosUsuarioModule } from './component/dados-usuario/dados-usuario.module';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    ReactiveFormsModule,
    SocialLoginModule,
    HttpClientModule,
    DadosUsuarioModule,
    CadastroUsuarioModule,
    ToastModule,
    RippleModule,
    LoginModule,
    HomeModule
  ],
  providers: [
    {
        provide: LOCALE_ID,
        useValue: 'pt-BR',
    },
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '998689991370-2rhl1rotnh6dpb7jubcqhhhi7dbh1mda.apps.googleusercontent.com'
            )
          }
        ]
      } as SocialAuthServiceConfig,
    }
],
  bootstrap: [AppComponent]
})
export class AppModule { }
