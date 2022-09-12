import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { NotificationCheckoutComponent } from './components/notification-checkout/notification-checkout.component';
import { NotificationLoginComponent } from './components/notification-login/notification-login.component';
import { ProductComponent } from './components/product-search/product/product.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { ProductListComponent } from './components/product-search/product-list/product-list.component';
import { ProductSearchComponent } from './components/product-search/product-search.component';
import { HomeComponent } from './home/home.component';
import { ProductDetailsDeleteComponent } from './product-details-delete/product-details-delete.component';
import { ProductDetailsAddComponent } from './components/product-details/product-details-add/product-details-add.component';
import { ProductDetailsEditComponent } from './components/product-details/product-details-edit/product-details-edit.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';




const routes: Routes = [
  {path:'',component:HomeComponent},
  {path: 'product-search/products/:id', component:ProductComponent},
  {path: 'product-details-delete', component:ProductDetailsDeleteComponent},
  {path:'product-search',component:ProductSearchComponent},
  {path:'product-search/products',component:ProductListComponent},
  {path:'invoice-search',component:OrderDetailsComponent},
  {path: 'product-details-add', component:ProductDetailsAddComponent},
  {path: 'product-details-edit', component:ProductDetailsEditComponent},
  {path: 'notification-login', component:NotificationLoginComponent},
  {path: 'notification-checkout', component:NotificationCheckoutComponent},
  {path:'checkout', component:CheckoutComponent},
  {path: 'user-details', component:UserDetailsComponent},
  {path: 'shopping-cart', component: ShoppingCartComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
