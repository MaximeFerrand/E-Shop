import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/eshop/model/product';
import { ProductService } from 'src/app/eshop/services/product.service';

@Component({
  selector: 'app-electromenager',
  templateUrl: './electromenager.component.html',
  styleUrls: ['./electromenager.component.css']
})
export class ElectromenagerComponent implements OnInit {
  products: Product[] = [];
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.initProduit();
  }
  initProduit() {
    this.productService.findByCategory("électroménager").subscribe((data) => {
      console.log("data category",data);
      this.products = data;
      console.log("products",this.products)
    });
  }
}
