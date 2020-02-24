import { Product } from './product';

export class TotalRebillAmount {
  id: number;
  product: Product;
  dateCreated: Date;
  totalRebillValue: number;

  constructor(
  id?: number,
  product?: Product,
  dateCreated?: Date,
  totalRebillValue?: number
  ) {
    this.id = id;
    this.product = product;
    this.dateCreated = dateCreated;
    this.totalRebillValue = totalRebillValue;
  }

}
