import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { ProductSearchComponent } from './components/product-search/product-search.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { NotificationLoginComponent } from './components/notification-login/notification-login.component';
import { NotificationCheckoutComponent } from './components/notification-checkout/notification-checkout.component';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProductComponent } from './components/product-search/product/product.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { InvoiceService } from './services/invoice.service';
import { HeaderComponent } from './header/header.component'
import { ProductListComponent } from './components/product-search/product-list/product-list.component';
import { ProductService } from './services/product.service';
import { HomeComponent } from './home/home.component';
import { ProductDetailsDeleteComponent } from './product-details-delete/product-details-delete.component';
import { FormsModule } from '@angular/forms';
import { ProductDetailsAddComponent } from './components/product-details/product-details-add/product-details-add.component';
import { ProductDetailsEditComponent } from './components/product-details/product-details-edit/product-details-edit.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CheckoutComponent,
    ProductSearchComponent,
    RegisterUserComponent,
    UserDetailsComponent,
    ProductDetailsComponent,
    NotificationLoginComponent,
    NotificationCheckoutComponent,
    ProductComponent,
    OrderDetailsComponent,
    HeaderComponent,
    HomeComponent,
    ProductListComponent,
    ProductDetailsDeleteComponent,
    ProductDetailsAddComponent,
    ProductDetailsEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    FormsModule
    //CloudinaryModule
  ],
  providers: [ProductService, InvoiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
