import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/eshop/model/user';
import { UserService } from 'src/app/eshop/services/user.service';


@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css'],
})
export class UserEditComponent implements OnInit {
  user: User = new User();
  constructor(
    private activatedRoute: ActivatedRoute,
    private userSrv: UserService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.userSrv.findById(params['id']).subscribe((data) => {
          this.user = data;
        });
      }
    });
  }

  save() {
    if (this.user.id) {
      this.userSrv
        .update(this.user)
        .subscribe(() => this.router.navigateByUrl('/admin/user'));
    } else {
      this.userSrv.create(this.user).subscribe(() => {
        this.router.navigateByUrl('/admin/user');
      });
    }
  }
}

