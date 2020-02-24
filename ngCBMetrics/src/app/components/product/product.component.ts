import { ProductService } from './../../services/product.service';
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product[] = [];
  selectedProduct: Product;
  notes = false;

  constructor(
    private prodSvc: ProductService,
  ) { }

  ngOnInit() {
  this.loadProducts();
  }

  loadProducts() {
    this.prodSvc.index().subscribe(
      data => {
        this.products = data;
      },
      error => {
        console.error('ProductComponent.index(): Error getting all products');
        console.error(error);
      }
    );
  }

}
