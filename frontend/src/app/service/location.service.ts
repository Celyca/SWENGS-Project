import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Location} from '../api/location';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private http: HttpClient) {
  }

  // ---------------------------------------------------------------------------------

  getById(id: number) {
    return this.http.get('/api/dto/locations/' + id);
  }

  create(location: Location) {
    return this.http.post('/api/dto/locations', location);
  }

  update(location: Location) {
    return this.http.put('/api/dto/locations/' + location.id, location);
  }

  delete(location: Location) {
    return this.http.delete('/api/dto/locations/' + location.id);
  }

  getAll() {
    return this.http.get('/api/dto/locations');
  }

  // ---------------------------------------------------------------------------------

}
