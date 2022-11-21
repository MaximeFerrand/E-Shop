import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/eshop/services/authentication.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  constructor(private authSrv: AuthenticationService, private router: Router) {}

  ngOnInit(): void {}
  logoff() {
    sessionStorage.clear();
    this.router.navigateByUrl('/home');
  }

  get anonymous() {
    return !this.authSrv.isAuthenticated();
  }

  get authenticated() {
    return this.authSrv.isAuthenticated();
  }
}
