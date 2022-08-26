import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ProductListComponent } from './components/product-search/product-list/product-list.component';
import { ProductSearchComponent } from './components/product-search/product-search.component';

const routes: Routes = [
  {path:'product-search',component:ProductSearchComponent},
  {path:'product-search/products',component:ProductListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
