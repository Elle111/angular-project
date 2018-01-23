import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';

@Injectable()
export class GetProductListService {

  constructor(private http: Http) { }

  getProductList() {
    let url = 'http://localhost:8181/product/productList';
    let headers = new Headers ({
      'Content-Type': 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });

    return this.http.get(url, {headers: headers});
  }


}
