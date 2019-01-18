import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {LocationService} from '../service/location.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-location-form',
  templateUrl: './location-form.component.html',
  styleUrls: ['./location-form.component.scss']
})
export class LocationFormComponent implements OnInit {

  locationForm;

  constructor(private locationService: LocationService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.locationForm = new FormGroup({
      'id': new FormControl(),
      'name': new FormControl(),
      'email': new FormControl(),
      'zip': new FormControl(),
      'city': new FormControl(),
      'address': new FormControl(),
      'phone': new FormControl(),
      'animals': new FormControl(),
      'users': new FormControl(),
    });

    const data = this.route.snapshot.data;
    const location = data.location;
    if (location) {
      this.locationForm.setValue(location);
    }
  }

  saveLocation() {
    const location = this.locationForm.value;
    if (location.id) {
      this.locationService.update(location)
        .subscribe((response) => {
          alert('updated successfully');
          this.navigateBack();
        });
    } else {
      this.locationService.create(location)
        .subscribe((response: any) => {
          alert('created successfully');
          this.navigateBack();
        });
    }
  }

  navigateBack() {
    this.router.navigate(['/locations']);
  }
}
