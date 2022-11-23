import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  NgForm,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { map, Observable } from 'rxjs';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css'],
})
export class ContactComponent implements OnInit {
  form!: FormGroup;
  validation = false;
  constructor(private clientService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      groupeInfo: new FormGroup({
        prenom: new FormControl('', [
          Validators.required,
          Validators.minLength(3),
        ]),
        nom: new FormControl('', [
          Validators.required,
          Validators.minLength(3),
        ]),
        entreprise: new FormControl('', Validators.minLength(3)),
        adresse: new FormControl('', Validators.minLength(10)),
        email: new FormControl('', [Validators.required, Validators.email]),
        telephone: new FormControl('', [
          Validators.required,
          Validators.minLength(10),
        ]),
        message: new FormControl('', [
          Validators.required,
          Validators.maxLength(350),
        ]),
      }),
    });
  }

  formIsValid() {
    if (this.form.valid) {
      this.validation = true;
    } else {
      this.validation = false;
    }
    this.form.reset();
  }
}
