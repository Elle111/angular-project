import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {AddNewProductComponent} from './components/add-new-product/add-new-product.component';
import {ProductListComponent} from './components/product-list/product-list.component';
import {ViewProductComponent} from './components/view-product/view-product.component';
import {EditProductComponent} from './components/edit-product/edit-product.component';


const appRoutes: Routes = [
  {
    path : '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'addNewProduct',
    component: AddNewProductComponent
  },
  {
    path: 'productList',
    component: ProductListComponent
  },
  {
    path: 'viewProduct/:id',
    component: ViewProductComponent
  },
  {
    path: 'editProduct/:id',
    component: EditProductComponent
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
