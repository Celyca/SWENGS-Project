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
    return this.http.get('/api/dto/animals/' + id);
  }

  create(animal: Animal) {
    if (animal.image) {
      animal.image = animal.image.id;
    }
    return this.http.post('/api/dto/animals', animal);
  }

  update(animal: Animal) {
    if (animal.image) {
      animal.image = animal.image.id;
    }
    return this.http.put('/api/dto/animals/' + animal.id, animal);
  }

  delete(animal: Animal) {
    return this.http.delete('/api/dto/animals/' + animal.id);
  }

  getAll() {
    return this.http.get('/api/dto/animals');
  }

  count() {
    return this.http.get('/api/dto/animals/count/');
  }

  // ---------------------------------------------------------------------------------

}

