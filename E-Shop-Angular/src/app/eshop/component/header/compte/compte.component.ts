import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/eshop/model/user';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit {
  userAccount!: User;
  constructor() { }

  ngOnInit(): void {
    this.userAccount = JSON.parse(sessionStorage.getItem('user')!);
  }

}
