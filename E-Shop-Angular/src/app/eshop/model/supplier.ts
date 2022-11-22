import { Account } from "./account";
import { Product } from "./product";

export class Supplier extends Account {
  public get products(): Product[] | undefined {
    return this._products;
  }
  public set products(value: Product[] | undefined) {
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
    private _products?: Product[]
  ) {
    super(_id, _login, _password);
  }
}
