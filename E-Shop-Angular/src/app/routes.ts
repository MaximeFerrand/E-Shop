import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ContactComponent } from './eshop/component/contact/contact.component';
import { CompteComponent } from './eshop/component/header/compte/compte.component';

import { AllComponent } from './eshop/component/header-footer/header/navigation/all/all.component';
import { HomeComponent } from './eshop/component/home/home.component';
import { ProblemAdminComponent } from './eshop/component/problem-admin/problem-admin.component';
import { SigninComponent } from './eshop/component/signin/signin.component';
import { SupplierEditComponent } from './eshop/component/supplier/supplier-edit/supplier-edit.component';
import { SupplierListComponent } from './eshop/component/supplier/supplier-list/supplier-list.component';
import { AchatComponent } from './eshop/component/user/achat/achat.component';
import { SupplierSignupComponent } from './eshop/component/supplier/supplier-signup/supplier-signup.component';
import { EditComponent } from './eshop/component/user/edit/edit.component';
import { PayementComponent } from './eshop/component/user/payement/payement.component';
import { ProductEditComponent } from './eshop/component/user/product/product-edit/product-edit.component';
import { ProductListComponent } from './eshop/component/user/product/product-list/product-list.component';
import { SignupComponent } from './eshop/component/user/signup/signup.component';
import { UserEditComponent } from './eshop/component/user/user-edit/user-edit.component';
import { UserListComponent } from './eshop/component/user/user-list/user-list.component';

import { AdminGuardService } from './eshop/guard/admin-guard.service';
import { AnonymousGuardService } from './eshop/guard/anonymous-guard.service';
import { SupplierGuardService } from './eshop/guard/supplier-guard.service';
import { BanqueComponent } from './eshop/component/user/banque/banque.component';
import { StoryComponent } from './eshop/component/pages/story/story.component';
import { DecorationComponent } from './eshop/component/header-footer/header/navigation/decoration/decoration.component';
import { MeublesComponent } from './eshop/component/header-footer/header/meubles/meubles.component';
import { ElectromenagerComponent } from './eshop/component/header-footer/header/navigation/electromenager/electromenager.component';
import { LingesComponent } from './eshop/component/header-footer/header/navigation/linges/linges.component';
import { EntretienComponent } from './eshop/component/header-footer/header/navigation/entretien/entretien.component';
import { TriComponent } from './eshop/component/tri/tri.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'product',
    component: ProductListComponent,
  },
  {path: 'entretien',
  component: EntretienComponent,
},
  {
    path: 'deco',
    component: DecorationComponent,
  },
  {
    path: 'triprice',
    component: TriComponent,
  },
  {
    path: 'linges',
    component: LingesComponent,
  },
  {
    path: 'product/edit',
    component: ProductEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'electro',
    component: ElectromenagerComponent,

  },
  {
    path: 'product/edit/:id',
    component: ProductEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'meubles',
    component: MeublesComponent ,

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
  { path: 'all', component: AllComponent },
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
    path: 'story',
    component: StoryComponent,
  },
  {
    path: 'user/edit/:id',
    component: EditComponent,
  },
  {
    path: 'user/achat',
    component: AchatComponent,
  },
  {
    path: 'user/payement',
    component: PayementComponent,
  },
  {
    path: 'user/banque',
    component: BanqueComponent,
  },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
