import { Component, OnInit } from '@angular/core';
import { AddProductService } from '../../services/add-product.service';
import { Product } from '../../models/product';
import { UploadImageService } from '../../services/upload-image.service';

@Component({
  selector: 'app-add-new-product',
  templateUrl: './add-new-product.component.html',
  styleUrls: ['./add-new-product.component.css']
})
export class AddNewProductComponent implements OnInit {
  private newProduct: Product = new Product();
  private productAdded: boolean;

  constructor(private addProductService: AddProductService, private uploadImageService: UploadImageService) { }

  onSubmit() {
    this.addProductService.sendProduct(this.newProduct).subscribe(
      res => {
        this.uploadImageService.upload(JSON.parse(JSON.parse(JSON.stringify(res))._body).id);
        this.productAdded = true;
        this.newProduct = new Product();
        this.newProduct.active = true;
        this.newProduct.category = 'Coffee';
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit() {
    this.productAdded = false;
    this.newProduct.active = true;
    this.newProduct.category = 'Coffee';
  }

}
