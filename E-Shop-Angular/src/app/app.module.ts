import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavigationComponent } from './eshop/component/header-footer/header/navigation/navigation.component';
import { HomeComponent } from './eshop/component/home/home.component';
import { PromotionComponent } from './eshop/component/header-footer/header/promotion/promotion.component';
import { ConnexionComponent } from './eshop/component/header-footer/header/connexion/connexion.component';
import { HeaderComponent } from './eshop/component/header-footer/header/header.component';
import { WelcomeComponent } from './eshop/component/home/welcome/welcome.component';
import { NavigationHomeComponent } from './eshop/component/home/navigation-home/navigation-home.component';
import { BestsellersComponent } from './eshop/component/home/bestsellers/bestsellers.component';
import { ConfortComponent } from './eshop/component/home/confort/confort.component';
import { PresentationComponent } from './eshop/component/home/presentation/presentation.component';
import { MarquesComponent } from './eshop/component/home/marques/marques.component';
import { FooterComponent } from './eshop/component/header-footer/footer/footer.component';
import { SocialMediaComponent } from './eshop/component/header-footer/social-media/social-media.component';
import { ProductComponent } from './eshop/component/user/product/product/product.component';
import { ProductEditComponent } from './eshop/component/user/product/product-edit/product-edit.component';
import { ProductListComponent } from './eshop/component/user/product/product-list/product-list.component';
import { SupplierListComponent } from './eshop/component/user/supplier/supplier-list/supplier-list.component';
import { SupplierEditComponent } from './eshop/component/user/supplier/supplier-edit/supplier-edit.component';
import { SignupComponent } from './eshop/component/user/signup/signup.component';
import { SigninComponent } from './eshop/component/signin/signin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { routes } from './routes';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthenticationInterceptor } from './eshop/interceptor/authentication.interceptor';
import { ProblemAdminComponent } from './eshop/component/problem-admin/problem-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    HomeComponent,
    PromotionComponent,
    ConnexionComponent,
    HeaderComponent,
    WelcomeComponent,
    NavigationHomeComponent,
    BestsellersComponent,
    ConfortComponent,
    PresentationComponent,
    MarquesComponent,
    FooterComponent,
    SocialMediaComponent,
    ProductComponent,
    ProductEditComponent,
    ProductListComponent,
    SupplierListComponent,
    SupplierEditComponent,
    SignupComponent,
    SigninComponent,
    ProblemAdminComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthenticationInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
