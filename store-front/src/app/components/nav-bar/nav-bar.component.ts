import { Component, OnInit } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { LoginService } from '../../services/login.service';
import {ProductService} from '../../services/product.service';
import {Product} from '../../models/product';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  private loggedIn = false;
  private keyword: string;
  private productList: Product[] =[];

  constructor(private loginService: LoginService, private productService: ProductService, private router: Router,) { }

  logout() {
    this.loginService.logout().subscribe(
      res => {
        location.reload();
      },
      err => {
        console.log(err);
      }
    );
  }

  onSearchByName() {
    this.productService.searchProduct(this.keyword).subscribe(
      res => {
        this.productList = res.json();
        console.log(this.productList);
        let navigationExtras: NavigationExtras = {
          queryParams: {
            'productList' : JSON.stringify(this.productList)
          }
        };

        this.router.navigate(['/productList'], navigationExtras);
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit() {
    this.loginService.checkSession().subscribe(
      res => {
        this.loggedIn = true;
      },
      err => {
        this.loggedIn = false;
      }
    );
  }

}
