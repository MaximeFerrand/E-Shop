import { Account } from './account';

export class Admin extends Account {
  constructor(login?: string, password?: string, id?: number) {
    super(id, login, password);
  }
}
