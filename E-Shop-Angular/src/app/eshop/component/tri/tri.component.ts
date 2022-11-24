import { Component, OnInit } from '@angular/core';
import { Product } from '../../model/product';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-tri',
  templateUrl: './tri.component.html',
  styleUrls: ['./tri.component.css']
})
export class TriComponent implements OnInit {
  productstri: Product[] = [];
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }
  Ascprice(){
    this.productService.triprice().subscribe((data) => {
      this.productstri = data;
    });
  }
}
