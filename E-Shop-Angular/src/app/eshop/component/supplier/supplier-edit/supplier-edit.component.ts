import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Supplier } from 'src/app/eshop/model/supplier';
import { SupplierService } from 'src/app/eshop/services/supplier.service';

@Component({
  selector: 'app-supplier-edit',
  templateUrl: './supplier-edit.component.html',
  styleUrls: ['./supplier-edit.component.css'],
})
export class SupplierEditComponent implements OnInit {
  supplier: Supplier = new Supplier();
  constructor(
    private activatedRoute: ActivatedRoute,
    private supplierSrv: SupplierService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.supplierSrv.findById(params['id']).subscribe((data) => {
          this.supplier = data;
        });
      }
    });
  }

  save() {
    if (this.supplier.id) {
      this.supplierSrv
        .update(this.supplier)
        .subscribe(() => this.router.navigateByUrl('/admin/supplier'));
    } else {
      this.supplierSrv.create(this.supplier).subscribe(() => {
        this.router.navigateByUrl('/admin/supplier');
      });
    }
  }
}
