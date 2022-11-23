import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/eshop/model/user';
import { AuthenticationService } from 'src/app/eshop/services/authentication.service';
import { SigninComponent } from '../../../signin/signin.component';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  userAccount!: User;

  constructor(private authSrv: AuthenticationService, private router: Router) {}

  ngOnInit(): void {
    this.userAccount = JSON.parse(sessionStorage.getItem('user')!);
    console.log(this.userAccount.firstName)
  }

  logoff() {
    sessionStorage.clear();
    this.router.navigateByUrl('/home');
  }

  logChange() {
    sessionStorage.clear();
    this.router.navigateByUrl('/signin');
  }

  get anonymous() {
    return !this.authSrv.isAuthenticated();
  }

  get user() {
    return this.authSrv.isUser();
  }

  get admin() {
    return this.authSrv.isAdmin();
  }

  get supplier() {
    return this.authSrv.isSupplier();
  }

  get authenticated() {
    return this.authSrv.isAuthenticated();
  }
}
