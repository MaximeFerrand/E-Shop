import { Product } from './product';
import { Review } from './review';

export class OrderDetail {
  public get review(): Review | undefined {
    return this._review;
  }
  public set review(value: Review | undefined) {
    this._review = value;
  }
  public get product(): Product | undefined {
    return this._product;
  }
  public set product(value: Product | undefined) {
    this._product = value;
  }
  public get quantity(): number | undefined {
    return this._quantity;
  }
  public set quantity(value: number | undefined) {
    this._quantity = value;
  }
  constructor(
    private _quantity?: number,
    private _product?: Product,
    private _review?: Review
  ) {}
}
