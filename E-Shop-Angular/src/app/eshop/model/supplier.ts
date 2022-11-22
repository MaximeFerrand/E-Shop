import { Account } from "./account";
import { Product } from "./product";

export class Supplier extends Account {
  public get products(): any[] | undefined {
    return this._products;
  }
  public set products(value: any[] | undefined) {
    this._products = value;
  }
  public get company(): string | undefined {
    return this._company;
  }
  public set company(value: string | undefined) {
    this._company = value;
  }
  constructor(
    _id?: number,
    _login?: string,
    _password?: string,
    private _company?: string,
    private _products?: any[]
  ) {
    super(_id, _login, _password);
  }
}
