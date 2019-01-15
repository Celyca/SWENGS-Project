import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {SpeciesService} from '../service/species.service';

@Injectable({
  providedIn: 'root'
})
export class SpeciesListResolver implements Resolve<Observable<any>> {

  constructor(private speciesService: SpeciesService) {
  }

  resolve(route: ActivatedRouteSnapshot,
          state: RouterStateSnapshot): Observable<Observable<any>> | Promise<Observable<any>> | Observable<any> {
    return this.speciesService.getAll();
  }
}
