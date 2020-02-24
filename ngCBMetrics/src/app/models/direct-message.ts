import { UserProfile } from './user-profile';

export class DirectMessage {
  id: number;
  composerProfile: UserProfile;
  recipientProfile: UserProfile;
  message: string;
  datePosted: Date;

  constructor(
  id?: number,
  composerProfile?: UserProfile,
  recipientProfile?: UserProfile,
  message?: string,
  datePosted?: Date
  ) {
    this.id = id;
    this.composerProfile = composerProfile;
    this.recipientProfile = recipientProfile;
    this.message = message;
    this.datePosted = datePosted;
  }
}
