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

  public findAll(): Observable<User[]> {
    return this.httpClient.get<User[]>(UserService.URL);
  }

  public findById(id: number): Observable<User> {
    return this.httpClient.get<User>(`${UserService.URL}/${id}`);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${UserService.URL}/${id}`);
  }

  public update(user: User): Observable<User> {
    return this.httpClient.patch<User>(
      `${UserService.URL}/${user.id}`,
      this.userToJson(user)
    );
  }
  public create(user: User): Observable<User> {
    return this.httpClient.post<User>(
      UserService.URL,
      this.userToJson(user)
    );
  }

  public userToJson(user: User): any {
    let userJson = {
      login: user.login,
      lastname: user.lastname,
      firstname: user.firstname,
    };
   /* if (user.adress) {
       },,
      });
    }*/
    if (user.id) {
      Object.assign(userJson, { id: user.id });
    }
    return userJson;
  }
}
