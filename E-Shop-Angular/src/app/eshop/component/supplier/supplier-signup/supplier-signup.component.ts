import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { map, Observable } from 'rxjs';
import { UserService } from 'src/app/eshop/services/user.service';

@Component({
  selector: 'app-supplier-signup',
  templateUrl: './supplier-signup.component.html',
  styleUrls: ['./supplier-signup.component.css'],
})
export class SupplierSignupComponent implements OnInit {
  form!: FormGroup;

  constructor(private clientService: UserService, private router: Router) {}

  ngOnInit(): void {
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
    });
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
