import { UserProfile } from './user-profile';
import { Product } from './product';

export class ProductNotes {
  id: number;
  userProfile: UserProfile;
  product: Product;
  dateCreated: Date;
  notes: string;

  constructor(
  id?: number,
  userProfile?: UserProfile,
  product?: Product,
  dateCreated?: Date,
  notes?: string
  ) {
  this.id = id;
  this.userProfile = userProfile;
  this.product = product;
  this.dateCreated = dateCreated;
  this.notes = notes;
  }
}
