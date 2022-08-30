import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductListComponent } from './components/product-search/product-list/product-list.component';
import { ProductSearchComponent } from './components/product-search/product-search.component';
import { HomeComponent } from './home/home.component';
import { ProductDetailsDeleteComponent } from './product-details-delete/product-details-delete.component';


const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'product-search', component:ProductSearchComponent},
  {path: 'product-search/products', component:ProductListComponent},
  {path: 'product-details-delete', component:ProductDetailsDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
