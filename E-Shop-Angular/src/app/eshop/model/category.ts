import { Product } from './product';

export class Category {
  public get products(): Product[] | undefined {
    return this._products;
  }
  public set products(value: Product[] | undefined) {
    this._products = value;
  }
  public get labelcat(): string | undefined {
    return this._labelcat;
  }
  public set labelcat(value: string | undefined) {
    this._labelcat = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  constructor(
    private _id?: number,
    private _labelcat?: string,
    private _products?: Product[]
  ) {}
}
