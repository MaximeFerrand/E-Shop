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
  ajouterPanier(id: string) {
    let tempPanier: Map<string, string>;


    console.log("session storage = ", sessionStorage);
    if (sessionStorage.getItem('panier')) {
      tempPanier = new Map(Object.entries(JSON.parse(sessionStorage.getItem('panier')!.toString())));
    } else {
      tempPanier = new Map<string, string>();
    }

    console.log("tempPanier", tempPanier);

    if (tempPanier.has(id)) {
      tempPanier.set(id, (parseInt(tempPanier.get(id)!) + 1).toString());
    } else {
      tempPanier.set(id, "1");
    }

    sessionStorage.setItem('panier', JSON.stringify(Object.fromEntries(tempPanier)));

    console.log("produit ajouté");
    console.log(sessionStorage.getItem('panier'));
   // this.productService.updateCalcul();
  }

  get panier(): Map<number, number> {
    let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);
    let panier: Map<number, number> = new Map<number, number>();
    for (let value in jsonObject) {
      panier.set(parseInt(value), jsonObject[value]);
    }
    return panier;
  }

}
