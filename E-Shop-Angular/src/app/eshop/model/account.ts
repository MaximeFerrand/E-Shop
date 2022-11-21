export class Account {
  public get password(): string |undefined {
    return this._password;
  }
  public set password(value: string |undefined) {
    this._password = value;
  }
  public get login(): string |undefined {
    return this._login;
  }
  public set login(value: string |undefined) {
    this._login = value;
  }
  public get id(): number  |undefined{
    return this._id;
  }
  public set id(value: number  |undefined) {
    this._id = value;
  }
  constructor(
    private _id?: number,
    private _login?: string,
    private _password?: string,

  ) {}
}
