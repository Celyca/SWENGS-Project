import { Component, OnInit } from '@angular/core';
import {Location} from '../api/location';
import {Offer} from '../api/offer';
import {ActivatedRoute, Router} from '@angular/router';
import {OfferService} from '../service/offer.service';
import {UserProfile} from '../api/profile';

@Component({
  selector: 'app-offer-list',
  templateUrl: './offer-list.component.html',
  styleUrls: ['./offer-list.component.scss']
})
export class OfferListComponent implements OnInit {

  offers: Array<Offer>;
  locations: Array<Location>;
  species: Array<any>;
  employees: Array<UserProfile>;

  constructor(private offerService: OfferService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.offerService.getAll()
      .subscribe((offers: any) => {
        this.offers = offers;
      });

    const data = this.route.snapshot.data;
    this.offers = data.offers;
    this.locations = data.locations;
    this.species = data.species;
    this.employees = data.employees;
  }

  createOffer() {
    this.router.navigate(['/offer-form']);
  }

  deleteOffer(offer: Offer) {
    this.offerService.delete(offer)
      .subscribe(() => {
        this.ngOnInit();
      });
  }
}
