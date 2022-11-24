
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
  produit !:Product;
  quantity!:number;
  compteur!:number;
  total:number=0;

  constructor(private produitSrv: ProductService) {}


  ngOnInit(): void {
    this.produit=new Product();
    if (!sessionStorage.getItem('panier')) {
      sessionStorage.setItem(
        'panier',
        JSON.stringify(new Map<number, number>())
      );

    }


    //console.log("xxxxx");


    //console.log(" panier recupere"+this.panier);

    this.getProduitPanier().forEach(element=> {
      //console.log("element"+element);

      this.produitSrv.findById(element).subscribe((data) => {
        console.log(data);
        this.produit= new Product(

          data.id,
          data.label,
          data.price,
          data.picture
        )
        this.produits.push(this.produit);

        this.compteur=this.produits.length;
        console.log("produits ajoutes au panier"+this.produits);





      }

      )

    });
    /*this.produits.forEach(element => {
      this.total+= element!.quantity! * element!.price!;

    });*/
  }


/*
  ajouterPanier(id: number) {
    let map: Map<number, number> = this.panier;
    if (map.has(id)) {
      map.set(id, map.get(id)! + 1);
    } else {
      map.set(id, 1);
    }
    sessionStorage.setItem('panier', JSON.stringify(Object.fromEntries(map)));
  }

  retirerPanier(id: number) {
    let map: Map<number, number> = this.panier;
    if (map.get(id) == 1) {
      map.delete(id);
    } else {
      map.set(id, map.get(id)! - 1);
    }
    sessionStorage.setItem('panier', JSON.stringify(Object.fromEntries(map)));
  }*/



  get panier(): Map<number, number> {
    let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);
    let panier: Map<number, number> = new Map<number, number>();
    for (let value in jsonObject) {
      panier.set(parseInt(value), jsonObject[value]);
    }
    //console.log(" panier recupere get"+this.panier);
    return panier;

  }



  getQuantite(id: number): number {
    let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);
    return jsonObject[id];
  }

  getProduitPanier():number[]{
    let map: Map<number, number>=this.panier;
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
      sessionStorage.setItem('panier',JSON.stringify(this.produits))
    }

  }
  changementQuantity(p:Product, index:number):void{
    sessionStorage.setItem('panier',JSON.stringify(this.produits))
    this.total=0;
    console.log("produit :"+JSON.stringify(p)+", index :"+index);

    this.total+=p!.quantity!*p!.price!;

  }
}
