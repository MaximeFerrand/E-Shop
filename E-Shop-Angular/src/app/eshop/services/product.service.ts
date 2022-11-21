import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';
import { SupplierService } from './supplier.service';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(
    private httpClient: HttpClient,
    private supplierSrv: SupplierService
  ) {}

  public findAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(
      'http://localhost:8080/eshop/api/product'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/eshop/api/product/${id}`
    );
  }

  public findById(id: number): Observable<Product> {
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
