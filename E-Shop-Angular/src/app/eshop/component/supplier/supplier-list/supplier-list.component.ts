import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Supplier } from 'src/app/eshop/model/supplier';
import { ProductService } from 'src/app/eshop/services/product.service';
import { SupplierService } from 'src/app/eshop/services/supplier.service';

@Component({
  selector: 'app-supplier-list',
  templateUrl: './supplier-list.component.html',
  styleUrls: ['./supplier-list.component.css'],
})
export class SupplierListComponent implements OnInit {
  suppliersObservable!: Observable<Supplier[]>;

  constructor(private supplierSrv: SupplierService, private productSrv : ProductService) {}

  ngOnInit(): void {
    this.suppliersObservable = this.supplierSrv.findAll();
  }

  delete(id: number) {
    this.supplierSrv.deleteById(id).subscribe(() => {
      this.suppliersObservable = this.supplierSrv.findAll();
    });
  }
}
