import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SpeciesService {

  constructor(private http: HttpClient) {
  }

  // ---------------------------------------------------------------------------------

  getAnimalsBySpecies(id: number) {
    return this.http.get('/api/dto/species/' + id);
  }

  getAll() {
    return this.http.get('/api/dto/species');
  }

  // ---------------------------------------------------------------------------------
}
