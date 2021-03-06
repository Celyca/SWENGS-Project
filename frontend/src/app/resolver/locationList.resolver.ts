import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {LocationService} from '../service/location.service';

@Injectable({
  providedIn: 'root'
})
export class LocationListResolver implements Resolve<Observable<any>> {

  constructor(private locationService: LocationService) {
  }

  resolve(route: ActivatedRouteSnapshot,
          state: RouterStateSnapshot): Observable<Observable<any>> | Promise<Observable<any>> | Observable<any> {
    return this.locationService.getAll();
  }
}
