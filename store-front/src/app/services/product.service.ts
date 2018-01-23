import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';
import {AppConst} from '../constants/app-const';

@Injectable()
export class ProductService {
 // private serverPath: string = AppConst.serverPath;

  constructor(private http: Http) { }

  getProductList() {
    let url = AppConst.serverPath + '/product/productList';

    let tokenHeader = new Headers({
      'Content-Type' : 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });
    return this.http.get(url, {headers: tokenHeader});
  }

  getProduct(id: number) {
    let url = AppConst.serverPath + '/product/' + id;

    let tokenHeader = new Headers({
      'Content-Type' : 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });
    return this.http.get(url, {headers: tokenHeader});
  }

  searchProduct(keyword: string) {
    let url = AppConst.serverPath + '/product/searchProduct';

    let tokenHeader = new Headers({
      'Content-Type' : 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });
    return this.http.post(url, keyword, {headers: tokenHeader});
  }

}
