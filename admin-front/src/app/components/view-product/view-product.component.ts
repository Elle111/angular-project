import { Component, OnInit } from '@angular/core';
import {Params, ActivatedRoute, Router} from '@angular/router';
import {Product} from '../../models/product';
import {GetProductService} from '../../services/get-product.service';
@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {

  private product: Product = new Product();
  private productId: number;

  constructor(private getProductService: GetProductService,
              private route: ActivatedRoute, private router: Router) { }

  onSelect(product: Product) {
    this.router.navigate(['/editProduct', this.product.id])
    // .then(s => location.reload())
    ;
  }

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.productId = Number.parseInt(params['id']);
    });

    this.getProductService.getProduct(this.productId).subscribe(
      res => {
        this.product = res.json();
      },
      error => {
        console.log(error);
      }
    );
  }
}
