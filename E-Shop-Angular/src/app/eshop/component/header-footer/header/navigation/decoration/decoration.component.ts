import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/eshop/model/category';
import { Product } from 'src/app/eshop/model/product';
import { ProductService } from 'src/app/eshop/services/product.service';

@Component({
  selector: 'app-decoration',
  templateUrl: './decoration.component.html',
  styleUrls: ['./decoration.component.css']
})
export class DecorationComponent implements OnInit {
  products: Product[] = [];
  category!:Category
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.initProduit();
  }
  initProduit() {
    this.productService.findAll().subscribe((data) => {
      this.products = data;
    });
  }
}
