import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/eshop/model/product';
import { ProductService } from 'src/app/eshop/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.initProduit();
  }

  initProduit() {
    this.productService.findAll().subscribe((data) => {
      this.products = data;
    });
  }

  delete(id: number) {
    this.productService.deleteById(id).subscribe(() => {
      this.initProduit();
    });
  }
}
