import { Product } from './product';

export class Commission {
  id: number;
  product: Product;
  dateCreated: Date;
  commissionValue: number;

  constructor(
  id?: number,
  product?: Product,
  dateCreated?: Date,
  commissionValue?: number
  ) {
    this.id = id;
    this.product = product;
    this.dateCreated = dateCreated;
    this.commissionValue = commissionValue;
  }
}
