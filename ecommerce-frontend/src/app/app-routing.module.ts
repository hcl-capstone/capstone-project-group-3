import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotificationCheckoutComponent } from './components/notification-checkout/notification-checkout.component';
import { NotificationLoginComponent } from './components/notification-login/notification-login.component';
import { ProductComponent } from './components/product-search/product/product.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { ProductDetailsDeleteComponent } from './product-details-delete/product-details-delete.component';
import { ProductDetailsAddComponent } from './components/product-details/product-details-add/product-details-add.component';
import { ProductDetailsEditComponent } from './components/product-details/product-details-edit/product-details-edit.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';
import { OrderStatusComponent } from './components/order-status/order-status.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { OktaAuthGuard, OktaCallbackComponent } from '@okta/okta-angular';
import { ProfileComponent } from './components/profile/profile.component';
import { AdminProductListComponent } from './components/admin-page/admin-product-list/admin-product-list.component';
import { AdminProductDetailsComponent } from './components/admin-page/admin-product-details/admin-product-details.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { ProductSearchComponent } from './components/product-search/product-search.component';
import { ProductListComponent } from './components/product-search/product-list/product-list.component';
import { HomeComponent } from './home/home.component';
import { AdminOrderListComponent } from './components/admin-page/admin-order-list/admin-order-list.component';
import { AdminOrderDetailsComponent } from './components/admin-page/admin-order-details/admin-order-details.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { AdminUserDetailsComponent } from './components/admin-page/admin-user-details/admin-user-details.component';
import { AdminUserListComponent } from './components/admin-page/admin-user-list/admin-user-list.component';




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
  {path: 'shopping-cart', component: ShoppingCartComponent},
  {path: 'order-status', component: OrderStatusComponent},
  {path: 'order-status/:id', component: CartDetailsComponent},
  {path: 'register-user', component: RegisterUserComponent},
  {path: 'profile', component: ProfileComponent, canActivate: [OktaAuthGuard] },
  {path: 'protected', loadChildren: () => import('./components/protected/protected.module').then(m => m.ProtectedModule), canActivate: [OktaAuthGuard] },
  {path: 'login/callback', component: OktaCallbackComponent },
  {path: 'admin/home', component:AdminHomeComponent},
  {path: 'admin/product-list', component: AdminProductListComponent},
  {path: 'admin/product-list/:id', component: AdminProductDetailsComponent},
  {path: 'admin/invoice-list', component: AdminOrderListComponent},
  {path: 'admin/invoice-list/:id', component: AdminOrderDetailsComponent},
  {path: 'user/profile', component: UserProfileComponent},
  {path: 'admin/user-list', component: AdminUserListComponent},
  {path: 'admin/user-list/:id', component: AdminUserDetailsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
