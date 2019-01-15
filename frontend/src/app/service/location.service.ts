import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Location} from '../api/location';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private http: HttpClient) {
  }

  // ---------------------------------------------------------------------------------

  getById(id: number) {
    return this.http.get('/api/locations/' + id);
  }

  create(location: Location) {
    return this.http.post('/api/locations', location);
  }

  update(location: Location) {
    return this.http.put('/api/locations/' + location.id, location);
  }

  delete(location: Location) {
    return this.http.delete('/api/locations/' + location.id);
  }

  getAll() {
    return this.http.get('/api/locations');
  }

  // ---------------------------------------------------------------------------------

}
