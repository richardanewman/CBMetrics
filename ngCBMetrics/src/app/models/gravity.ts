import { Product } from './product';

export class Gravity {
  id: number;
  product: Product;
  dateCreated: Date;
  gravityValue: number;

  constructor(
  id?: number,
  product?: Product,
  dateCreated?: Date,
  gravityValue?: number
  ) {
    this.id = id;
    this.product = product;
    this.dateCreated = dateCreated;
    this.gravityValue = gravityValue;
  }
}
