import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {AnimalService} from '../service/animal.service';

@Injectable({
  providedIn: 'root'
})
export class AnimalListResolver implements Resolve<Observable<any>> {

  constructor(private animalService: AnimalService) {
  }

  resolve(route: ActivatedRouteSnapshot,
          state: RouterStateSnapshot): Observable<Observable<any>> | Promise<Observable<any>> | Observable<any> {
    return this.animalService.getAll();
  }
}
