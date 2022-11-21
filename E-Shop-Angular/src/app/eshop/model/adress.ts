export class Adress {
  public get city(): string | undefined {
    return this._city;
  }
  public set city(value: string | undefined) {
    this._city = value;
  }
  public get pc(): string | undefined {
    return this._pc;
  }
  public set pc(value: string | undefined) {
    this._pc = value;
  }
  public get way(): string | undefined {
    return this._way;
  }
  public set way(value: string | undefined) {
    this._way = value;
  }
  public get number(): string | undefined {
    return this._number;
  }
  public set number(value: string | undefined) {
    this._number = value;
  }
  constructor(
    private _number?: string,
    private _way?: string,
    private _pc?: string,
    private _city?: string
  ) {}
}
