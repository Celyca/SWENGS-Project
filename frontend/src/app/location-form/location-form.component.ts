import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {LocationService} from '../service/location.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-location-form',
  templateUrl: './location-form.component.html',
  styleUrls: ['./location-form.component.scss']
})
export class LocationFormComponent implements OnInit {

  locationForm;

  constructor(private locationService: LocationService,
              private route: ActivatedRoute,
              private router: Router,
              private toastr: ToastrService) {
  }

  ngOnInit() {
    this.locationForm = new FormGroup({
      'id': new FormControl(),
      'name': new FormControl('', [Validators.required]),
      'email': new FormControl('', [Validators.required]),
      'zip': new FormControl('', [Validators.required]),
      'city': new FormControl('', [Validators.required]),
      'address': new FormControl('', [Validators.required]),
      'phone': new FormControl('', [Validators.required]),
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
          this.toastr.success(location.name + ' wurde aktualisiert.', 'ERFOLG!');
          this.navigateBack();
        });
    } else {
      this.locationService.create(location)
        .subscribe((response: any) => {
          this.toastr.success(location.name + ' wurde erstellt.', 'ERFOLG!');
          this.navigateBack();
        });
    }
  }

  navigateBack() {
    this.router.navigate(['/locations']);
  }
}
