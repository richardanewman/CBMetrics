import { Product } from './product';

export class Referred {
  id: number;
  product: Product;
  dateCreated: Date;
  referredValue: number;

  constructor(
  id?: number,
  product?: Product,
  dateCreated?: Date,
  referredValue?: number
  ) {
    this.id = id;
    this.product = product;
    this.dateCreated = dateCreated;
    this.referredValue = referredValue;
  }
}
