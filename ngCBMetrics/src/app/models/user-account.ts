import { Timestamp } from 'rxjs';

export class UserAccount {
  id: number;
  email: string;
  password: string;
  role: string;
  enabled: boolean;
  registrationTimestamp: Date;
  username: string;

  constructor(
    id?: number,
    email?: string,
    password?: string,
    role?: string,
    enabled?: boolean,
    registrationTimestamp?: Date,
    username?: string
  ) {
    this.id = id,
    this.email = email,
    this. password = password,
    this.role = role,
    this.enabled = enabled,
    this.registrationTimestamp = registrationTimestamp,
    this.username = username;
  }

}
