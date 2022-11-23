import { Account } from './account';
import { Adress } from './adress';

export class User extends Account {
  public get adresses(): Adress[] | undefined {
    return this._adresses;
  }
  public set adresses(value: Adress[] | undefined) {
    this._adresses = value;
  }
  public get lastname(): string | undefined {
    return this._lastname;
  }
  public set lastname(value: string | undefined) {
    this._lastname = value;
  }
  public get firstname(): string | undefined {
    return this._firstname;
  }
  public set firstname(value: string | undefined) {
    this._firstname = value;
  }
  constructor(
    _id?: number,
    _login?: string,
    private _firstname?: string,
    private _lastname?: string,
    private _adresses?: Adress[]
  ) {
    super(_id, _login);
  }
}
