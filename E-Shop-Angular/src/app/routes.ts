import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ContactComponent } from './eshop/component/contact/contact.component';
import { CompteComponent } from './eshop/component/header/compte/compte.component';

import { HomeComponent } from './eshop/component/home/home.component';
import { ProblemAdminComponent } from './eshop/component/problem-admin/problem-admin.component';
import { SigninComponent } from './eshop/component/signin/signin.component';
import { SupplierEditComponent } from './eshop/component/supplier/supplier-edit/supplier-edit.component';
import { SupplierListComponent } from './eshop/component/supplier/supplier-list/supplier-list.component';
import { SupplierSignupComponent } from './eshop/component/supplier/supplier-signup/supplier-signup.component';
import { EditComponent } from './eshop/component/user/edit/edit.component';
import { ProductEditComponent } from './eshop/component/user/product/product-edit/product-edit.component';
import { ProductListComponent } from './eshop/component/user/product/product-list/product-list.component';
import { SignupComponent } from './eshop/component/user/signup/signup.component';
import { UserEditComponent } from './eshop/component/user/user-edit/user-edit.component';
import { UserListComponent } from './eshop/component/user/user-list/user-list.component';

import { AdminGuardService } from './eshop/guard/admin-guard.service';
import { AnonymousGuardService } from './eshop/guard/anonymous-guard.service';
import { SupplierGuardService } from './eshop/guard/supplier-guard.service';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'product',
    component: ProductListComponent,
  },
  {
    path: 'product/edit',
    component: ProductEditComponent,
    canActivate: [AdminGuardService, SupplierGuardService],
  },
  {
    path: 'product/edit/:id',
    component: ProductEditComponent,
    canActivate: [AdminGuardService, SupplierGuardService],
  },
  {
    path: 'admin/supplier',
    component: SupplierListComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'admin/user-list',
    component: UserListComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'admin/user-edit',
    component: UserEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'admin/user-edit/:id',
    component: UserEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'admin/supplier/edit',
    component: SupplierEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'admin/supplier/edit/:id',
    component: SupplierEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'signup',
    component: SignupComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'signin',
    component: SigninComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'contact',
    component: ContactComponent,
  },
  {
    path: 'supplier/signup',
    component: SupplierSignupComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'problem/admin',
    component: ProblemAdminComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'compte',
    component: CompteComponent,

  },
  {
    path: 'user/edit/:id',
    component:EditComponent,

  },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
