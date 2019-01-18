import { Component, OnInit } from '@angular/core';
import {Location} from '../api/location';
import {ActivatedRoute, Router} from '@angular/router';
import {LocationService} from '../service/location.service';
import {Animal} from '../api/animal';

@Component({
  selector: 'app-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.scss']
})
export class LocationListComponent implements OnInit {

  locations: Array<Location>;

  constructor(private locationService: LocationService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.locationService.getAll()
      .subscribe((locations: any) => {
        this.locations = locations;
      });

    const data = this.route.snapshot.data;
    this.locations = data.locations;
  }

  createLocation() {
    this.router.navigate(['/location-form']);
  }

  deleteLocation(location: Location) {
    this.locationService.delete(location)
      .subscribe(() => {
        this.ngOnInit();
      });
  }
}
