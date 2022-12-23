import { ICustomer } from 'app/entities/customer/customer.model';

export interface ICreditCard {
  id: number;
  number?: string | null;
  bank?: string | null;
  cardHolder?: Pick<ICustomer, 'id' | 'name'> | null;
}

export type NewCreditCard = Omit<ICreditCard, 'id'> & { id: null };
