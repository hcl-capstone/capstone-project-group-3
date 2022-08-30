import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductDetailsAddComponent } from './components/product-details/product-details-add/product-details-add.component';
import { ProductDetailsEditComponent } from './components/product-details/product-details-edit/product-details-edit.component';
import { ProductListComponent } from './components/product-search/product-list/product-list.component';
import { ProductSearchComponent } from './components/product-search/product-search.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'product-search', component:ProductSearchComponent},
  {path: 'product-search/products', component:ProductListComponent},
  {path: 'product-details-add', component:ProductDetailsAddComponent},
  {path: 'product-details-edit', component:ProductDetailsEditComponent}
//  {path: 'product-search/productName',component:ProductSearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
