import { AuthGuardService } from './guard/auth-guard.service';
import { HomeModule } from './pages/home/shared/home.module';
import { HomeComponent } from './pages/home/home.component';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { NgModule} from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginModule } from './pages/login/shared/login.module';
import { LoginComponent } from './pages/login/login.component';
import { CadastroUsuarioComponent } from './pages/cadastro-usuario/cadastro-usuario.component';


const routes: Routes = [
  {
    path: '', component: HomeComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'login', component: LoginComponent,
  },
  {
    path: 'home', component: HomeComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'cadastro', component: CadastroUsuarioComponent,
  }

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule],
  providers: [
    { provide: LocationStrategy, useClass: HashLocationStrategy }
]
})
export class AppRoutingModule { }
