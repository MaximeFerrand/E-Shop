import { Injectable } from '@angular/core';
import { Supplier } from '../model/supplier';

@Injectable({
  providedIn: 'root',
})
export class SupplierService {
  supplierToJson(arg0: Supplier) {
    throw new Error('Method not implemented.');
  }

  constructor() {}
}
