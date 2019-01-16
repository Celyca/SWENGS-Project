import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Offer} from '../api/offer';

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  constructor(private http: HttpClient) {
  }

  // ---------------------------------------------------------------------------------

  getById(id: number) {
    return this.http.get('/api/dto/offers/' + id);
  }

  create(offer: Offer) {
    return this.http.post('/api/dto/offers', offer);
  }

  update(offer: Offer) {
    return this.http.put('/api/dto/offers/' + offer.id, offer);
  }

  delete(offer: Offer) {
    return this.http.delete('/api/dto/offers/' + offer.id);
  }

  getAll() {
    return this.http.get('/api/dto/offers');
  }

  // ---------------------------------------------------------------------------------

}
