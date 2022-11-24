
import { JsonPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/eshop/model/product';
import { ProductService } from 'src/app/eshop/services/product.service';

@Component({
  selector: 'app-achat',
  templateUrl: './achat.component.html',
  styleUrls: ['./achat.component.css'],
})
export class AchatComponent implements OnInit {
  produits: Product[] = [];
  quantity!:number;
  compteur:number=0;
  total:number = 0;

  constructor(private produitSrv: ProductService) {}

  ngOnInit(): void {
    let panier = this.getProduitPanier()

    panier.forEach(element=> {
      console.log("Key => " + element);

      this.produitSrv.findById(element).subscribe((data) => {
        console.log(data);

        let produit = new Product(
          data.id,
          data.label,
          data.price,
          data.picture,
          this.panier.get(element)
        )
        this.produits.push(produit);

        this.compteur += this.panier.get(element)!;
        this.total += this.panier.get(element)! * produit.price!;
      })
    });

    console.log("produits ajoutes au panier"+this.produits);
  }

  get panier(): Map<number, number> {
    let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);

    let panier: Map<number, number> = new Map<number, number>();

    for (let value in jsonObject) {
      panier.set(parseInt(value), parseInt(jsonObject[value]));
    }

    return panier;
  }

  getLongueurPanier():number{
    return this.produits.length;
  }

  getQuantite(id: number): number {
    let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);
    return jsonObject[id];
  }

  getProduitPanier():number[] {

    let map: Map<number, number> = this.panier;
    let tab: number[] =[];

    let n=JSON.parse(JSON.stringify(Object.fromEntries(map)));

    for (let value in n) {
      tab.push(parseInt(value));

    }
    return tab;
  }

  delete(id:number):void{

    if(this.produits[id].quantity==0){
      this.produits.splice(id,1);
      sessionStorage.clear;
      sessionStorage.setItem('panier',JSON.stringify(this.produits))
    }

  }
  changementQuantity(p:Product, index:number):void{
    sessionStorage.clear;

    this.total = 0;

    this.produits.forEach(prod => {
      this.total += prod!.quantity! * prod!.price!;
    })

    ;
    sessionStorage.setItem('compteur',JSON.stringify(this.calculCompteur()));
    sessionStorage.setItem('panier',JSON.stringify(this.produits))
    sessionStorage.setItem('compteur',JSON.stringify(this.compteur));
    sessionStorage.setItem('totalPrix',JSON.stringify(this.total));
    //this.produitSrv.updateCalcul();
  }

 calculCompteur(){
  this.compteur=0;
  this.produits.forEach(element => {
    this.compteur+=element.quantity!;

  });
  ///console.log("compteur"+this.compteur)


 }

}
