import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CookieServiceService {

  constructor() { }

    /**
   * Método para setar Cookies enviando o nome, o valor e qtd de dias
   *
   * @params name
   * @params value
   * @params days
   */
  setCookie(keyName, value, days) {

    var expires = new Date().getTime() + (days * 24 * 60 * 60 * 1000);
    var cookie = {
      data: value,
      timeout: expires
    }
    localStorage.setItem(keyName, JSON.stringify(cookie));
  }

  /**
 * Método para recuperar cookies especificos
 *
 * @params name
 */
  getCookie(keyName) {
    if (localStorage) {
      let cookie: any = localStorage.getItem(keyName);
      if (cookie != null) {
        cookie = JSON.parse(cookie);
        if (cookie.timeout != null && new Date().getTime() > cookie.timeout) {
          localStorage.removeItem(keyName);
        } else {
          return cookie.data;
        }
      }
    }
    return undefined;
  }

  /**
 * Função que apaga todos os cookies do sistema
 */
  deleteCookie(keyName) {
    localStorage.removeItem(keyName);
  }
}


