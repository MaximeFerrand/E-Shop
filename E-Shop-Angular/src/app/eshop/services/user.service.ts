import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  static URL: string = 'http://localhost:8080/eshop/api/user';

  constructor(private httpClient: HttpClient) {}

  public signup(user: any): Observable<User> {
    return this.httpClient.post<User>(`${UserService.URL}/signup`, user);
  }

  public checkEmailExists(email: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      `${UserService.URL}/check/email/${email}`
    );
  }
}
