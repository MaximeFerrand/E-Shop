import { Account } from "./account";
import { Adress } from "./adress";

export class User extends Account{
  public get discount(): number|undefined {
    return this._discount;
  }
  public set discount(value: number|undefined ) {
    this._discount = value;
  }
  public get adress(): Adress[]|undefined  {
    return this._adress;
  }
  public set adress(value: Adress[]|undefined ) {
    this._adress = value;
  }
  public get lastName(): string |undefined {
    return this._lastName;
  }
  public set lastName(value: string|undefined ) {
    this._lastName = value;
  }
  public get firstName(): string|undefined  {
    return this._firstName;
  }
  public set firstName(value: string|undefined ) {
    this._firstName = value;
  }
  constructor(
     _id?: number,
    _login?: string,
    _password?: string,
    private _firstName?: string,
    private _lastName?: string,
    private _adress?: Adress[],
    private _discount?: number,




  ) {
    super(_id, _login, _password);
  }
}
