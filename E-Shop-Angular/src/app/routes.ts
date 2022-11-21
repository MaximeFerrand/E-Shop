import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './eshop/component/home/home.component';
import { ProblemAdminComponent } from './eshop/component/problem-admin/problem-admin.component';
import { SigninComponent } from './eshop/component/signin/signin.component';
import { ProductEditComponent } from './eshop/component/user/product/product-edit/product-edit.component';
import { ProductListComponent } from './eshop/component/user/product/product-list/product-list.component';
import { SignupComponent } from './eshop/component/user/signup/signup.component';
import { SupplierEditComponent } from './eshop/component/user/supplier/supplier-edit/supplier-edit.component';
import { SupplierListComponent } from './eshop/component/user/supplier/supplier-list/supplier-list.component';
import { AdminGuardService } from './eshop/guard/admin-guard.service';
import { SupplierGuardService } from './eshop/guard/supplier-guard.service';

export const routes: Routes = [
  { path: 'home', component: AppComponent },
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
    path: 'supplier',
    component: SupplierListComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'supplier/edit',
    component: SupplierEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'supplier/edit/:id',
    component: SupplierEditComponent,
    canActivate: [AdminGuardService, SupplierGuardService],
  },
  {
    path: 'signup',
    component: SignupComponent,
    canActivate: [],
  },
  {
    path: 'signin',
    component: SigninComponent,
    canActivate: [],
  },
  {
    path: 'problem/admin',
    component: ProblemAdminComponent,
    canActivate: [AdminGuardService],
  },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
