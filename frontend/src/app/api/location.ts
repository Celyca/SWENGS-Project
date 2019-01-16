export interface Location {
  id?: number;
  name: string;
  email: string;
  zip: number;
  city: string;
  address: string;
  phone: string;
  animals?: Array<any>;
  users?: Array<any>;
}
