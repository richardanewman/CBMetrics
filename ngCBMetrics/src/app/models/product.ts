export class Product {
  id: number;
  cbID: string;
  popularityRank: number;
  title: string;
  description: string;
  hasRecurringProducts: boolean;
  gravity: number;
  percentPerSale: number;
  percentPerRebill: number;
  avgEarningsPerSale: number;
  initialEarningsPerSale: number;
  totalRebillAmt: number;
  referred: number;
  commission: number;
  activeDate: Date;

  constructor(
  id?: number,
  cbID?: string,
  popularityRank?: number,
  title?: string,
  description?: string,
  hasRecurringProducts?: boolean,
  gravity?: number,
  percentPerSale?: number,
  percentPerRebill?: number,
  avgEarningsPerSale?: number,
  initialEarningsPerSale?: number,
  totalRebillAmt?: number,
  referred?: number,
  commission?: number,
  activeDate?: Date
  ) {
  this.id = id;
  this.cbID = cbID;
  this.popularityRank = popularityRank;
  this.title = title;
  this.description = description;
  this.hasRecurringProducts = hasRecurringProducts;
  this.gravity = gravity;
  this.percentPerSale = percentPerSale;
  this.percentPerRebill = percentPerRebill;
  this.avgEarningsPerSale = avgEarningsPerSale;
  this.initialEarningsPerSale = initialEarningsPerSale;
  this.totalRebillAmt = totalRebillAmt;
  this.referred = referred;
  this.commission = commission;
  this.activeDate = activeDate;
  }
}
