import { Component, OnInit } from '@angular/core';
import {Location} from '../api/location';
import {Offer} from '../api/offer';
import {ActivatedRoute, Router} from '@angular/router';
import {OfferService} from '../service/offer.service';
import {UserProfile} from '../api/profile';
import {ToastrService} from 'ngx-toastr';
import {AdminService} from '../service/admin.service';

@Component({
  selector: 'app-offer-list',
  templateUrl: './offer-list.component.html',
  styleUrls: ['./offer-list.component.scss']
})
export class OfferListComponent implements OnInit {

  public chartType: String = 'pie';

  public chartDatasets: Array<any> = [
    {data: [18, 82]}
  ];
  public chartLabels: Array<any> = ['Verbesserungsbedarf', 'Zufrieden'];

  public chartColors: Array<any> = [
    {
      backgroundColor: ['#33adff', '#ff6600'],
    }
  ];
  public chartOptions: any = {
    responsive: true
  };

  offers: Array<Offer>;
  locations: Array<Location>;
  species: Array<any>;
  employees: Array<UserProfile>;
  admin: boolean;

  constructor(private offerService: OfferService,
              private router: Router,
              private route: ActivatedRoute,
              private toastr: ToastrService,
              private adminService: AdminService) {
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
    this.admin = this.adminService.isAdmin;
  }

  createOffer() {
    this.router.navigate(['/offer-form']);
  }

  deleteOffer(offer: Offer) {
    this.offerService.delete(offer)
      .subscribe(() => {
        this.ngOnInit();
        this.toastr.error('Angebot wurde gelöscht.', 'SCHADE!');
      });
  }
}
