import { Product } from './product';

export class PopularityRank {
  id: number;
  product: Product;
  dateCreated: Date;
  rankValue: number;

  constructor(
  id?: number,
  product?: Product,
  dateCreated?: Date,
  rankValue?: number
  ) {
    this.id = id;
    this.product = product;
    this.dateCreated = dateCreated;
    this.rankValue = rankValue;
  }
}
