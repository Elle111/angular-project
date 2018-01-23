import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';
import {Product} from '../models/product';

@Injectable()
export class RemoveProductService {

  constructor(private http: Http) { }

  sendProduct(productId: number) {
    let url = 'http://localhost:8181/product/remove';

    let headers = new Headers ({
      'Content-Type': 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });

    return this.http.post(url, productId, {headers: headers});
  }

}
