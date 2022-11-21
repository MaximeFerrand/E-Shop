import { Account } from "./account";
import { Product } from "./product";

export class Supplier extends Account{
  constructor(
    _id?: number,
   _login?: string,
   _password?: string,
   private company?: string,
   private products?: Product[],





 ) {
   super(_id, _login, _password);
 }
}
