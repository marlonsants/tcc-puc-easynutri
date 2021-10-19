import { Usuario } from './../../model/usuario.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dados-usuario',
  templateUrl: './dados-usuario.component.html',
  styleUrls: ['./dados-usuario.component.css']
})
export class DadosUsuarioComponent implements OnInit {

  usuario: Usuario = {};
  confirmacaoSenha: string = "";

  constructor() { }

  ngOnInit(): void {
  }

}
