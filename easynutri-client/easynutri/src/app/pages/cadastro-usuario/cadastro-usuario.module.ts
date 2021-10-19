import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DadosUsuarioModule } from '../../component/dados-usuario/dados-usuario.module';
import { CadastroUsuarioComponent } from './cadastro-usuario.component';

@NgModule({
  declarations: [CadastroUsuarioComponent],
  imports: [
    CommonModule,
    DadosUsuarioModule,
    RouterModule
  ]
})
export class CadastroUsuarioModule { }
