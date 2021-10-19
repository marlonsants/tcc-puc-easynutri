import { Usuario } from './../../model/usuario.model';
import { UsuarioService } from './../../component/dados-usuario/shared/usuario.service';
import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css'],

})
export class CadastroUsuarioComponent implements OnInit {

  constructor(
    private usuarioService: UsuarioService,
    private messageService: MessageService) { }

  ngOnInit(): void {
  }

  cadastrar(usuario: Usuario) {
    this.usuarioService.cadastrar(usuario).subscribe(usuario => {
      if (usuario != undefined) {
        this.messageService.add({severity: 'success', detail: 'Cadastro realizado com sucesso!'});
      }
    });

  }

}
