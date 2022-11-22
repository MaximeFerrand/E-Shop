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
    console.log('avant auth');
    this.authSrv.authentication(this.login, this.password).subscribe({
      next: (data) => {
        console.log(data);
        console.log('avant next');
        this.error = false;
        sessionStorage.setItem(
          'token',
          'Basic ' + window.btoa(this.login + ':' + this.password)
        );
        if (data.role == 'ROLE_USER') {

          let user = new User(
            data.id,
            data.login,

            data.firstname,
            data.lastname,
            data.adresses ? data.adresses: undefined,

          );
          sessionStorage.setItem('user', JSON.stringify(user));

          sessionStorage.setItem('role', 'user');
          sessionStorage.setItem('account', JSON.stringify(data.login));
        } else if (data.role == 'ROLE_ADMIN') {
          sessionStorage.setItem('account', JSON.stringify(data.login));
          sessionStorage.setItem('role', 'admin');
        } else if (data.role == 'ROLE_SUPPLIER') {
          let supplier = new Supplier(
            data.id,
            data.company,
            data.product ? data.product : undefined,
            data.login
          );
          sessionStorage.setItem('supplier', JSON.stringify(supplier));
          sessionStorage.setItem('role', 'supplier');
          sessionStorage.setItem('account', JSON.stringify(data.login));
        }
        console.log("hello"+sessionStorage.getItem('user'));
        console.log('avant home');
        this.router.navigateByUrl('/home');
        console.log('apres home');
      },
      error: (err) => {
        this.error = true;
      },
    });

  }
}
