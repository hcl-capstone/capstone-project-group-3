import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotificationCheckoutComponent } from './components/notification-checkout/notification-checkout.component';
import { NotificationLoginComponent } from './components/notification-login/notification-login.component';
import { ProductListComponent } from './components/product-search/product-list/product-list.component';
import { ProductSearchComponent } from './components/product-search/product-search.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'product-search', component:ProductSearchComponent},
  {path: 'product-search/products', component:ProductListComponent},
  {path: 'notification-login', component:NotificationLoginComponent},
  {path: 'notification-checkout', component:NotificationCheckoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
