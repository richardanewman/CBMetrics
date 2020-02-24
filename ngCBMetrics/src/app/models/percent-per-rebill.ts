import { Product } from './product';

export class PercentPerRebill {
  id: number;
  product: Product;
  dateCreated: Date;
  rebillValue: number;

  constructor(
  id?: number,
  product?: Product,
  dateCreated?: Date,
  rebillValue?: number
  ) {
    this.id = id;
    this.product = product;
    this.dateCreated = dateCreated;
    this.rebillValue = rebillValue;
  }
}
