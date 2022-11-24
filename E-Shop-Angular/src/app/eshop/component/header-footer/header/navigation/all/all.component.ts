import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/eshop/model/product';
import { ProductService } from 'src/app/eshop/services/product.service';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {
  products: Product[] = [];


  constructor(private productService: ProductService) { }

  ngOnInit(): void {

    if (!sessionStorage.getItem('panier')) {
      sessionStorage.setItem(
        'panier',
        JSON.stringify(new Map<number, number>())
      );
    }
    this.initProduit();

  }

  ajouterPanier(id: number) {

    let map: Map<number, number> = this.panier;
    if (map.has(id)) {
      map.set(id, map.get(id)! + 1);
    } else {
      map.set(id, 1);
    }
    sessionStorage.setItem('panier', JSON.stringify(Object.fromEntries(map)));
    console.log("produit ajouté");
    console.log(sessionStorage.getItem('panier'));
  }

  get panier(): Map<number, number> {
    let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);
    let panier: Map<number, number> = new Map<number, number>();
    for (let value in jsonObject) {
      panier.set(parseInt(value), jsonObject[value]);
    }
    return panier;
  }


  initProduit() {
    this.productService.findAll().subscribe((data) => {
      this.products = data;
    });
  }

}
