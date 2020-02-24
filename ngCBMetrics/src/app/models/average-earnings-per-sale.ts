import { Product } from './product';

export class AverageEarningsPerSale {
  id: number;
  product: Product;
  dateCreated: Date;
  avgEarningsValue: number;

  constructor(
  id?: number,
  product?: Product,
  dateCreated?: Date,
  avgEarningsValue?: number
  ) {
    this.id = id;
    this.product = product;
    this.dateCreated = dateCreated;
    this.avgEarningsValue = avgEarningsValue;
  }
}
