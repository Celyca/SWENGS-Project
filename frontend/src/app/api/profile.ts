export interface UserProfile {
  id?: number;
  username: string;
  firstName: string;
  lastName: string;
  dayOfBirth: Date;
  email: string;
  zip: number;
  city: string;
  address: string;
  phone: string;
  locations?: Array<any>;
  image?: any;
}
