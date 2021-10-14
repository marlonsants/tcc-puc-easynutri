import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router, UrlSegment } from '@angular/router';

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
          this.hidden = this.router.url === '/login';
        }
      }
    );

  }

}
