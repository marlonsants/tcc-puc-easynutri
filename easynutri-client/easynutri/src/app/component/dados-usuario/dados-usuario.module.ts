import { FormsModule } from '@angular/forms';
import { DadosUsuarioComponent } from './dados-usuario.component';
import { NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    DadosUsuarioComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  exports:[
    DadosUsuarioComponent
  ]
})
export class DadosUsuarioModule { }
