import { Product } from './product';

export class PercentPerSale {
  id: number;
  product: Product;
  dateCreated: Date;
  percentageValue: number;

  constructor(
  id?: number,
  product?: Product,
  dateCreated?: Date,
  percentageValue?: number
  ) {
    this.id = id;
    this.product = product;
    this.dateCreated = dateCreated;
    this.percentageValue = percentageValue;
  }
}
