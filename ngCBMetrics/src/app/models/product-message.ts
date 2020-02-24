import { UserProfile } from './user-profile';
import { Product } from './product';

export class ProductMessage {
  id: number;
  userProfile: UserProfile;
  product: Product;
  message: string;
  repliedToProfile: UserProfile;
  datePosted: Date;

  constructor(
  id?: number,
  userProfile?: UserProfile,
  product?: Product,
  message?: string,
  repliedToProfile?: UserProfile,
  datePosted?: Date
  ) {
    this.id = id;
    this.userProfile = userProfile;
    this.product = product;
    this.message = message;
    this.repliedToProfile = repliedToProfile;
    this.datePosted = datePosted;
  }
}
