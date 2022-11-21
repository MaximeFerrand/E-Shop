export class Review {
  public get comment(): string | undefined {
    return this._comment;
  }
  public set comment(value: string | undefined) {
    this._comment = value;
  }
  public get notation(): number | undefined {
    return this._notation;
  }
  public set notation(value: number | undefined) {
    this._notation = value;
  }

  constructor(private _notation?: number, private _comment?: string) {}
}
