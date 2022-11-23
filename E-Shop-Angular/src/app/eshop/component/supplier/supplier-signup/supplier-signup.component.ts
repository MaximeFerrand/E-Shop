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
import { SupplierService } from 'src/app/eshop/services/supplier.service';
import { UserService } from 'src/app/eshop/services/user.service';

@Component({
  selector: 'app-supplier-signup',
  templateUrl: './supplier-signup.component.html',
  styleUrls: ['./supplier-signup.component.css'],
})
export class SupplierSignupComponent implements OnInit {
  form!: FormGroup;

  constructor(
    private supplierService: SupplierService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      login: new FormControl(
        '',
        [Validators.required, Validators.email],
        this.emailNotExists()
      ),
      groupeInfo: new FormGroup(
        {
          company: new FormControl('', [
            Validators.required,
            Validators.minLength(2),
          ]),
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
        this.contientCompany
      ),
    });
  }

  emailNotExists(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.supplierService.checkEmailExists(control.value).pipe(
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

  contientCompany(control: AbstractControl): ValidationErrors | null {
    let password = control.get('groupePassword.password');
    return password?.value
      .toString()
      .includes(control.get('company')?.value.toString())
      ? { contientCompany: true }
      : null;
  }

  save() {
    let supplier = {
      company: this.form.get('groupeInfo.company')?.value,
      login: this.form.get('login')?.value,
      password: this.form.get('groupeInfo.groupePassword.password')?.value,
    };
    this.supplierService.signup(supplier).subscribe((data) => {
      this.router.navigateByUrl('/home');
    });
  }
}
