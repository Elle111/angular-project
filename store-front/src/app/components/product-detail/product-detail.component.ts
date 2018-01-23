import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { ProductService } from '../../services/product.service';
import { CartService } from '../../services/cart.service';
import {Params, ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {AppConst} from '../../constants/app-const';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {


  private productId: number;
  private product: Product = new Product();
  private serverPath = AppConst.serverPath;
  private numberList: number[] = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  private qty: number;

  private addProductSuccess: boolean = false;
  private notEnoughStock: boolean = false;

  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private router: Router,
    private http: Http,
    private route: ActivatedRoute
  ) { }

  onAddToCart() {
    this.cartService.addItem(this.productId, this.qty).subscribe(
      res => {
        console.log(res.text());
        this.addProductSuccess = true;
      },
      err => {
        console.log(err.text());
        this.notEnoughStock = true;
      }
    );
  }



  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.productId = Number.parseInt(params['id']);
    });

    this.productService.getProduct(this.productId).subscribe(
      res => {
        this.product = res.json();
      },
      error => {
        console.log(error);
      }
    );

    this.qty = 1;
  }


}
