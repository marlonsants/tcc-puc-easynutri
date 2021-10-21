import { MessageService } from 'primeng/api';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent
} from '@angular/common/http';

import { catchError, map} from 'rxjs/operators';

@Injectable()
export class HttpErrorInterceptor implements HttpInterceptor {

  constructor(private messageService: MessageService){}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next.handle(request)
    .pipe(
      map(data => {
        return data;
      }),
      catchError(error => {
        if(error.error == undefined) {
          this.messageService.add({severity: 'error', detail: `Ocorreu um erro inesperado: ${error.message}`, life: 10000});
        } else {
          this.messageService.add({severity: 'error', detail: error.error.mensagemErro, life: 10000});

          if (error.error.erros != undefined) {
            let listaErros: any[] = error.error.erros;
            for (let erro of listaErros) {
              this.messageService.add({severity: 'info', detail: erro.mensagem, life: 10000});
            }
          }
         }

        return new Observable<HttpEvent<any>>();
      })
    );
  }
}
