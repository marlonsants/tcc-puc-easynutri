import { AuthService } from '../../auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(
    private router: Router,
    private authService: AuthService) { }

  hidden: boolean = false;

  ngOnInit(): void {

    this.router.events.subscribe(
      (event: any) => {
       this.hidden = !this.authService.usuarioEstaAutenticado();
      }
    );
  }

  logout(event: Event): void{
    event.preventDefault();
    this.authService.logout();
  }

}
