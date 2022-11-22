import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Supplier } from '../model/supplier';
import { ProductService } from './product.service';

@Injectable({
  providedIn: 'root',
})
export class SupplierService {
  static URL: string = 'http://localhost:8080/eshop/api/supplier';

  constructor(
    private httpClient: HttpClient,
    private productSrv: ProductService,
  ) {}

  public findAll(): Observable<Supplier[]> {
    return this.httpClient.get<Supplier[]>(SupplierService.URL);
  }

  public findById(id: number): Observable<Supplier> {
    return this.httpClient.get<Supplier>(`${SupplierService.URL}/${id}`);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${SupplierService.URL}/${id}`);
  }

  public update(supplier: Supplier): Observable<Supplier> {
    return this.httpClient.put<Supplier>(
      `${SupplierService.URL}/${supplier.id}`,
      this.supplierToJson(supplier)
    );
  }
  public create(supplier: Supplier): Observable<Supplier> {
    return this.httpClient.post<Supplier>(
      SupplierService.URL,
      this.supplierToJson(supplier)
    );
  }

  public supplierToJson(supplier: Supplier): any {
    let supplierJson = {
      login: supplier.login,
      company: supplier.company,
    };
    if (supplier.products) {
      Object.assign(supplierJson, {
        product: {
          id: supplier.products,
          label: supplier.products,
          price: supplier.products
        },
      });
    }
    if (supplier.id) {
      Object.assign(supplierJson, { id: supplier.id });
    }
    return supplierJson;
  }
}
