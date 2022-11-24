import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Product } from '../model/product';
import { SupplierService } from './supplier.service';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  compteur:number = 0;
  findByCategory(arg0: string):Observable<Product[]> {
    return this.httpClient.get<Product[]>(
      `http://localhost:8080/eshop/api/product/category/${arg0}`
    );
  }

  public subject$ = new Subject<string>();

  constructor(
    private httpClient: HttpClient,
    private supplierSrv: SupplierService,

  ) {}

  /*
  public updateCalcul2():Subject<number>{

    const subject = new Subject<number>();
    return new Observable(observer => {
      let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);

      let panier: Map<number, number> = new Map<number, number>();

      for (let value in jsonObject) {
          panier.set(parseInt(value), parseInt(jsonObject[value]));
      }
      panier.forEach(element=> {


          this.compteur += panier.get(element)!;


      });
      console.log("Compteur a diffuser = " + sessionStorage.getItem('compteur'));
      observer.next(this.compteur);
    });

    subject.subscribe({

      //next: (v) => console.log(`observerA: ${v}`),
    });

  }

  public updateCalcul() {
      this.compteur = 0;

      if(sessionStorage.getItem('panier')) {
        let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);

        let panier: Map<number, number> = new Map<number, number>();

        for (let value in jsonObject) {
            panier.set(parseInt(value), parseInt(jsonObject[value]));
        }

        console.log("Panier =", panier);

        panier.forEach(element => {
            this.compteur += element;
        });

        console.log("Compteur a diffuser = " + this.compteur);

        this.subject$.next(this.compteur.toString());
      } else {
        console.log("rien a afficher ");
        this.subject$.next("0");
      }
  }
*/




  public findAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(
      'http://localhost:8080/eshop/api/product'
    );
  }
  public triprice(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(
      'http://localhost:8080/eshop/api/product/tri'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/eshop/api/product/${id}`
    );
  }

  public  findById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(
      `http://localhost:8080/eshop/api/product/${id}`
    );
  }

  public update(product: Product): Observable<Product> {
    console.debug(product);
    return this.httpClient.patch<Product>(
      `http://localhost:8080/eshop/api/product/${product?.id}`,
      product
    );
  }

  public create(product: Product): Observable<Product> {
    console.debug(product);
    return this.httpClient.post<Product>(
      'http://localhost:8080/eshop/api/product',
      this.productToJson(product)
    );
  }

  private productToJson(product: Product): any {
    let productInJsonForJava = {
      label: product.label,
      price: product.price,
      supplier: this.supplierSrv.supplierToJson(product.supplier!),
    };
    return productInJsonForJava;
  }
}
