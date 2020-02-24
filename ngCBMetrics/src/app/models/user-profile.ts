import { UserAccount } from './user-account';
export class UserProfile {
  id: number;
  user: UserAccount;
  firstName: string;
  lastName: string;
  business: string;
  website: string;
  bio: string;
  profilePic: string;
  city: string;
  state: string;

  constructor(
    id?: number,
    user?: UserAccount,
    firstName?: string,
    lastName?: string,
    business?: string,
    website?: string,
    bio?: string,
    profilePic?: string,
    city?: string,
    state?: string
  ) {
    this.id = id;
    this.user = user;
    this.firstName = firstName;
    this.lastName = lastName;
    this.business = business;
    this.website = website;
    this.bio = bio;
    this.profilePic = profilePic;
    this.city = city;
    this.state = state;
  }
}
