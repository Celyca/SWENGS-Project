import { Component, OnInit } from '@angular/core';
import {AnimalService} from '../service/animal.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {OfferService} from '../service/offer.service';

@Component({
  selector: 'app-offer-form',
  templateUrl: './offer-form.component.html',
  styleUrls: ['./offer-form.component.scss']
})
export class OfferFormComponent implements OnInit {

  offerForm;
  locationOptions;
  speciesOptions;
  employeeOptions;

  constructor(private offerService: OfferService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.offerForm = new FormGroup({
      'id': new FormControl(),
      'description': new FormControl('', [Validators.required]),
      'duration': new FormControl('', [Validators.required]),
      'location': new FormControl('', [Validators.required]),
      'species': new FormControl('', [Validators.required]),
      'user': new FormControl('', [Validators.required]),
    });

    const data = this.route.snapshot.data;
    this.locationOptions = data.locations;
    this.speciesOptions = data.species;
    this.employeeOptions = data.employees;
    const offer = data.offer;
    if (offer) {
      this.offerForm.setValue(offer);
    }
  }

  saveOffer() {
    const offer = this.offerForm.value;
    if (offer.id) {
      this.offerService.update(offer)
        .subscribe((response) => {
          alert('updated successfully');
          this.navigateBack();
        });
    } else {
      this.offerService.create(offer)
        .subscribe((response: any) => {
          alert('created successfully');
          this.navigateBack();
        });
    }
  }

  navigateBack() {
    this.router.navigate(['/offers']);
  }

}
