import { Product } from './product';

export class InitialEarningsPerSale {
  id: number;
  product: Product;
  dateCreated: Date;
  initialEarningsValue: number;

  constructor(
  id?: number,
  product?: Product,
  dateCreated?: Date,
  initialEarningsValue?: number
  ) {
    this.id = id;
    this.product = product;
    this.dateCreated = dateCreated;
    this.initialEarningsValue = initialEarningsValue;
  }
}
