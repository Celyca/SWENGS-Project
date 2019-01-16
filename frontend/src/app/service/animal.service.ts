import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Animal} from '../api/animal';

@Injectable({
  providedIn: 'root'
})
export class AnimalService {

  constructor(private http: HttpClient) {
  }

  // ---------------------------------------------------------------------------------

  getById(id: number) {
    return this.http.get('/api/animals/' + id);
  }

  create(animal: Animal) {
    return this.http.post('/api/animals', animal);
  }

  update(animal: Animal) {
    return this.http.put('/api/animals/' + animal.id, animal);
  }

  delete(animal: Animal) {
    return this.http.delete('/api/animals/' + animal.id);
  }

  getAll() {
    return this.http.get('/api/animals');
  }

  // ---------------------------------------------------------------------------------

}

