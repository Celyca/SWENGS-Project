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
    return this.http.get('/api/events/' + id);
  }

  create(event: Event) {
    return this.http.post('/api/events', event);
  }

  update(event: Event) {
    return this.http.put('/api/events/' + event.id, event);
  }

  delete(event: Event) {
    return this.http.delete('/api/events/' + event.id);
  }

  getAll() {
    return this.http.get('/api/events');
  }

  // ---------------------------------------------------------------------------------

}
