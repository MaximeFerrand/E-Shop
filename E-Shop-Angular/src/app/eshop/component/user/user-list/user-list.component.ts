import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/eshop/model/user';
import { UserService } from 'src/app/eshop/services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
})
export class UserListComponent implements OnInit {
  usersObservable!: Observable<User[]>;
  //users! : User[];

  constructor(private userSrv: UserService,) {}

  /*ngOnInit(): void {
     this.userSrv.findAll().subscribe({
      next: (data) => {console.log("tab data"+data);
    }})

  }*/
  ngOnInit(): void {

    this.usersObservable = this.userSrv.findAll();
  }
  delete(id: number) {
    this.userSrv.deleteById(id).subscribe(() => {
      this.usersObservable = this.userSrv.findAll();
    });
  }
}
