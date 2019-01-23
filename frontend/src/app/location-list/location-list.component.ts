import { Component, OnInit } from '@angular/core';
import {Location} from '../api/location';
import {ActivatedRoute, Router} from '@angular/router';
import {LocationService} from '../service/location.service';
import {ToastrService} from 'ngx-toastr';
import {AdminService} from '../service/admin.service';

@Component({
  selector: 'app-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.scss']
})
export class LocationListComponent implements OnInit {

  locations: Array<Location>;
  admin: boolean;

  constructor(private locationService: LocationService,
              private router: Router,
              private route: ActivatedRoute,
              private toastr: ToastrService,
              private adminService: AdminService) {
  }

  ngOnInit() {
    this.locationService.getAll()
      .subscribe((locations: any) => {
        this.locations = locations;
      });

    const data = this.route.snapshot.data;
    this.locations = data.locations;
    this.admin = this.adminService.isAdmin;
  }

  createLocation() {
    this.router.navigate(['/location-form']);
  }

  deleteLocation(location: Location) {
    this.locationService.delete(location)
      .subscribe(() => {
        this.ngOnInit();
        this.toastr.error(location.name + ' wurde gelöscht.', 'SCHADE!');
      });
  }
}
