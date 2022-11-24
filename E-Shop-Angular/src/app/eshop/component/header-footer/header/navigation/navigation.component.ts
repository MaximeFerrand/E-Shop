import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/eshop/services/authentication.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css'],
})
export class NavigationComponent implements OnInit {
  constructor(private authSrv: AuthenticationService) {}

  ngOnInit(): void {


  }

  get admin() {
    return this.authSrv.isAdmin();
  }

  get user() {
    return this.authSrv.isUser();
  }

  get supplier() {
    return this.authSrv.isSupplier();
  }

  get anonymous() {
    return !this.authSrv.isAuthenticated();
  }
}
