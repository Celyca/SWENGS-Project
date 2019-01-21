import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Event} from '../api/event';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private http: HttpClient) {
  }

  // ---------------------------------------------------------------------------------

  getById(id: number) {
    return this.http.get('/api/dto/events/' + id);
  }

  create(event: Event) {
    return this.http.post('/api/dto/events', event);
  }

  update(event: Event) {
    return this.http.put('/api/dto/events/' + event.id, event);
  }

  delete(event: Event) {
    return this.http.delete('/api/dto/events/' + event.id);
  }

  getAllbyUser() {
    return this.http.get('/api/dto/events');
  }

  // ---------------------------------------------------------------------------------

}
