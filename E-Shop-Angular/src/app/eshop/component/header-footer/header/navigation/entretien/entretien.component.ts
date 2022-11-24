import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/eshop/model/product';
import { ProductService } from 'src/app/eshop/services/product.service';

@Component({
  selector: 'app-entretien',
  templateUrl: './entretien.component.html',
  styleUrls: ['./entretien.component.css']
})
export class EntretienComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.initProduit();
  }
  initProduit() {
    this.productService.findByCategory("entretien").subscribe((data) => {
      console.log("data category",data);
      this.products = data;
      console.log("products",this.products)
    });
  }
}
