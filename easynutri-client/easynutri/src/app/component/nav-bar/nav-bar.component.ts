import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

const ROTAS_SEM_NAV_BAR = ['/login', '/cadastro'];

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private router: Router) { }

  hidden: boolean = false;

  ngOnInit(): void {

    this.router.events.subscribe(
      (event: any) => {
        if (event instanceof NavigationEnd) {
          this.hidden = ROTAS_SEM_NAV_BAR.indexOf(this.router.url) != -1;
        }
      }
    );

  }

}
