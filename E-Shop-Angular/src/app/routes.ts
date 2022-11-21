import { Routes } from '@angular/router';
import { HomeComponent } from './eshop/component/home/home.component';
import { SigninComponent } from './eshop/component/signin/signin.component';
import { ProductEditComponent } from './eshop/component/user/product/product-edit/product-edit.component';
import { SignupComponent } from './eshop/component/user/signup/signup.component';
import { SupplierEditComponent } from './eshop/component/user/supplier/supplier-edit/supplier-edit.component';
import { SupplierListComponent } from './eshop/component/user/supplier/supplier-list/supplier-list.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'produit',
    component: ProductEditComponent,
    canActivate: [],
  },
  {
    path: 'produit/edit',
    component: ProductEditComponent,
    canActivate: [],
  },
  {
    path: 'produit/edit/:id',
    component: ProductEditComponent,
    canActivate: [],
  },
  {
    path: 'fournisseur',
    component: SupplierListComponent,
    canActivate: [],
  },
  {
    path: 'fournisseur/edit',
    component: SupplierEditComponent,
    canActivate: [],
  },
  {
    path: 'fournisseur/edit/:id',
    component: SupplierEditComponent,
    canActivate: [],
  },
  {
    path: 'inscription',
    component: SignupComponent,
    canActivate: [],
  },
  {
    path: 'login',
    component: SigninComponent,
    canActivate: [],
  },
];
