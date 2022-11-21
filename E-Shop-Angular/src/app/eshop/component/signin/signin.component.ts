import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Account } from '../../model/account';
import { Supplier } from '../../model/supplier';
import { User } from '../../model/user';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css'],
})
export class SigninComponent implements OnInit {
  login: string = '';
  password: string = '';
  error = false;

  constructor(private authSrv: AuthenticationService, private router: Router) {}

  ngOnInit(): void {}

  send() {
    this.authSrv.authentication(this.login, this.password).subscribe({
      next: (data) => {
        this.error = false;
        sessionStorage.setItem(
          'token',
          'Basic ' + window.btoa(this.login + ':' + this.password)
        );
        if (data.role == 'ROLE_USER') {
          let user = new User(
            data.user.id,
            data.user.firstname,
            data.user.lastname,
            data.user.adress ? data.adress : undefined,
            data.user.login
          );
          sessionStorage.setItem('user', JSON.stringify(user));
          sessionStorage.setItem('role', 'user');
          sessionStorage.setItem('account', JSON.stringify(data.login));
        } else if (data.role == 'ROLE_ADMIN') {
          sessionStorage.setItem('account', JSON.stringify(data.login));
          sessionStorage.setItem('role', 'admin');
        } else {
          let supplier = new Supplier(
            data.supplier.id,
            data.supplier.company,
            data.supplier.product ? data.product : undefined,
            data.user.login
          );
          sessionStorage.setItem('user', JSON.stringify(supplier));
          sessionStorage.setItem('role', 'supplier');
          sessionStorage.setItem('account', JSON.stringify(data.login));
        }
        this.router.navigateByUrl('/home');
      },
      error: (err) => {
        this.error = true;
      },
    });
  }
}
