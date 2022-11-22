import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/eshop/services/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  constructor(private authSrv: AuthenticationService) {}

  ngOnInit(): void {}

  get user() {
    return this.authSrv.isUser();
  }

  get anonymous() {
    return !this.authSrv.isAuthenticated();
  }
}
