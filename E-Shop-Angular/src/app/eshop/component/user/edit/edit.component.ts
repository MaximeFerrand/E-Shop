import { Component, OnInit } from '@angular/core';
import { AbstractControl, AsyncValidatorFn, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { map, Observable } from 'rxjs';
import { User } from 'src/app/eshop/model/user';
import { Adress } from 'src/app/eshop/model/adress';
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
  adresses:Adress[]=[];
  adress!:Adress;



  constructor(private authSrv: AuthenticationService,private clientService: UserService, private router: Router,private activatedRoute: ActivatedRoute,) {}

  ngOnInit(): void {
    this.adress=new Adress();
    this.user=new User();
    this.user.adresses=[this.adress];

    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        console.log("id:"+params['id']);

        this.clientService.findById(params['id']).subscribe((data) => {
          console.log(data);
         data.adresses!.forEach(element => {
            this.adress=new Adress(
              element.number,
              element.way,
              element.pc,
              element.city
            )
            console.log("adress "+this.adress);
          this.adresses.push(this.adress);
              console.log(this.adresses);
          });



          this.user=new User(data.id,
            data.login,
            data.firstname,
            data.lastname,
          this.adresses


          )
          //console.log("tesssst"+this.user.firstname);

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

  save() {
    if (this.user.id) {
      this.clientService.update(this.user).subscribe((data) => {
        this.router.navigateByUrl('/compte');
      });
    } else {
      this.clientService.create(this.user).subscribe((data) => {
        this.router.navigateByUrl('/compte');
      });
    }
  }
}
