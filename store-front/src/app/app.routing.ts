import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {HomeComponent} from './components/home/home.component';
import {MyAccountComponent} from './components/my-account/my-account.component';
import {MyProfileComponent} from './components/my-profile/my-profile.component';
import {ProductListComponent} from './components/product-list/product-list.component';
import {ProductDetailComponent} from './components/product-detail/product-detail.component';
import {ShoppingCartComponent} from './components/shopping-cart/shopping-cart.component';
import {OrderComponent} from './components/order/order.component';
import {OrderSummaryComponent} from './components/order-summary/order-summary.component';

const appRoutes: Routes = [
    {
      path: '',
      redirectTo: '/home',
      pathMatch: 'full'},
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'myAccount',
    component: MyAccountComponent
  },
  {
    path: 'productList',
    component: ProductListComponent
  },
  {
    path: 'myProfile',
    component: MyProfileComponent
  },
  {
    path: 'productDetail/:id',
    component: ProductDetailComponent
  },
  {
    path: 'shoppingCart',
    component: ShoppingCartComponent
  },
  {
    path: 'checkout',
    component: OrderComponent
  },
  {
    path: 'orderSummary',
    component: OrderSummaryComponent
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
