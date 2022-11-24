import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Product } from 'src/app/eshop/model/product';
import { ProductService } from 'src/app/eshop/services/product.service';

@Component({
  selector: 'app-payement',
  templateUrl: './payement.component.html',
  styleUrls: ['./payement.component.css'],
})
export class PayementComponent implements OnInit {
  form!: FormGroup;
  totalAvantPromo: number = 100;
  totalApresPromo: number = 0;

  selectedOption: string = '';
  actions = [
    { info: 'A domicile - ', prix: '5.0' },
    { info: 'En point relais - ', prix: '0.0' },
  ];

  constructor(private produitSrv: ProductService) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      selectedPromo: new FormControl('', Validators.pattern('JH2M')),
    });
    this.promo();
  }

  promo() {
    if (this.form) {
      this.totalApresPromo *= 1.1;
    }
  }

  onClick() {
    this.totalApresPromo = this.totalAvantPromo + parseInt(this.selectedOption);
  }
}
