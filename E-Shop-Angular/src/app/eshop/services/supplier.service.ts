import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';
import { Supplier } from '../model/supplier';
import { ProductService } from './product.service';

@Injectable({
  providedIn: 'root',
})
export class SupplierService {
  static URL: string = 'http://localhost:8080/eshop/api/supplier';

  constructor(private httpClient: HttpClient) {}

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
    return this.httpClient.patch<Supplier>(
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

  public signup(supplier: any): Observable<Supplier> {
    return this.httpClient.post<Supplier>(
      `${SupplierService.URL}/signup`,
      supplier
    );
  }

  public checkEmailExists(email: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      `${SupplierService.URL}/check/email/${email}`
    );
  }

  public supplierToJson(supplier: Supplier): any {
    let supplierJson = {
      login: supplier.login,
      company: supplier.company,
      password: supplier.password,
    };
    if (supplier.products) {
      // parcourir tableau -> transformer en JSON -> push en tableau -> Assign à l'Object
      /*Object.assign(supplierJson, {
        products: [{products.forEach(e => {numero: supplier.products.id,
        });

        }],
      });*/
    }
    if (supplier.id) {
      Object.assign(supplierJson, { id: supplier.id });
    }
    return supplierJson;
  }
}
