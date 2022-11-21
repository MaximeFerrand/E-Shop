import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Injectable({
  providedIn: 'root',
})
export class UserGuardService implements CanActivate {
  constructor(private authSrv: AuthenticationService, private router: Router) {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | boolean
    | UrlTree
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree> {
    if (this.authSrv.isAuthenticated()) {
      if (this.authSrv.isUser()) {
        return true;
      } else {
        return this.router.parseUrl('/problem/admin');
      }
    } else {
      return this.router.parseUrl('/login');
    }
  }
}
