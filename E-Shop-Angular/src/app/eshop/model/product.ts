import { Supplier } from './supplier';

export class Product {
  public get picture(): string | undefined {
    return this._picture;
  }
  public set picture(value: string | undefined) {
    this._picture = value;
  }
  public get supplier(): Supplier | undefined {
    return this._supplier;
  }
  public set supplier(value: Supplier | undefined) {
    this._supplier = value;
  }
  public get price(): number | undefined {
    return this._price;
  }
  public set price(value: number | undefined) {
    this._price = value;
  }
  public get label(): string | undefined {
    return this._label;
  }
  public set label(value: string | undefined) {
    this._label = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }

  constructor(
    private _id?: number,
    private _label?: string,
    private _price?: number,
    private _picture?: string,
    private _supplier?: Supplier
  ) {}
}
