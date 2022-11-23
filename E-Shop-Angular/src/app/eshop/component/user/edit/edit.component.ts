import { Component, OnInit } from '@angular/core';
import { AbstractControl, AsyncValidatorFn, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { map, Observable } from 'rxjs';
import { User } from 'src/app/eshop/model/user';
import { AuthenticationService } from 'src/app/eshop/services/authentication.service';
import { UserService } from 'src/app/eshop/services/user.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  user!:User;
  form!: FormGroup;

  constructor(private authSrv: AuthenticationService,private clientService: UserService, private router: Router,private activatedRoute: ActivatedRoute,) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        console.log("id:"+params['id']);

        this.clientService.findById(params['id']).subscribe((data) => {

          console.log(data);
          console.log("user : "+ this.user);
        });
      }
    });



    /*
    this.form = new FormGroup({
      numero: new FormControl(),
      voie: new FormControl(),
      cp: new FormControl(),
      ville: new FormControl(),
      login: new FormControl(
        '',
        [Validators.required, Validators.email],
        this.emailNotExists()
      ),
      groupeInfo: new FormGroup(
        {
          prenom: new FormControl('', [
            Validators.required,
            Validators.minLength(2),
          ]),
          nom: new FormControl('', Validators.required),
          groupePassword: new FormGroup(
            {
              password: new FormControl(
                '',
                Validators.pattern(
                  /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@*!-_])([a-zA-Z0-9@*!-_]{4,25})$/
                )
              ),
              confirmation: new FormControl(),
            },
            this.passwordAndConfirmatonEquals
          ),
        },
        this.contientPrenomOuNom
      ),
    });*/
  }
  get anonymous() {
    return !this.authSrv.isAuthenticated();
  }

  get user2() {
    return this.authSrv.isUser();
  }

  get admin() {
    return this.authSrv.isAdmin();
  }

  get supplier() {
    return this.authSrv.isSupplier();
  }

  emailNotExists(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.clientService.checkEmailExists(control.value).pipe(
        map((bool) => {
          return bool ? { emailExists: true } : null;
        })
      );
    };
  }

  passwordAndConfirmatonEquals(
    control: AbstractControl
  ): ValidationErrors | null {
    let password = control.get('password');
    if (password?.invalid) {
      return null;
    }
    return password?.value == control.get('confirmation')?.value
      ? null
      : { passwordAndConfirmationNotEquals: true };
  }

  contientPrenomOuNom(control: AbstractControl): ValidationErrors | null {
    let password = control.get('groupePassword.password');
    return password?.value
      .toString()
      .includes(control.get('prenom')?.value.toString()) ||
      password?.value.toString().includes(control.get('nom')?.value.toString())
      ? { contientPrenomOuNom: true }
      : null;
  }

  save() {
    let user = {
      firstname: this.form.get('groupeInfo.prenom')?.value,
      lastname: this.form.get('groupeInfo.nom')?.value,
      login: this.form.get('login')?.value,
      password: this.form.get('groupeInfo.groupePassword.password')?.value,
    };
    if (
      this.form.get('numero')?.value ||
      this.form.get('voie')?.value ||
      this.form.get('cp')?.value ||
      this.form.get('ville')?.value
    ) {
      Object.assign(user, {
        adresses: [
          {
            number: this.form.get('numero')?.value,
            way: this.form.get('voie')?.value,
            pc: this.form.get('cp')?.value,
            city: this.form.get('ville')?.value,
          },
        ],
      });
    }
    this.clientService.signup(user).subscribe((data) => {
      this.router.navigateByUrl('/home');
    });
  }

}
