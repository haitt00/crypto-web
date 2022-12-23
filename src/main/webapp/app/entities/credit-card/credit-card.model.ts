import { ICustomer } from 'app/entities/customer/customer.model';

export interface ICreditCard {
  id: number;
  number?: string | null;
  bank?: string | null;
  customer?: Pick<ICustomer, 'id'> | null;
}

export type NewCreditCard = Omit<ICreditCard, 'id'> & { id: null };
