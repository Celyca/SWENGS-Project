import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {AnimalService} from '../service/animal.service';
import {AdminService} from '../service/admin.service';

@Injectable({
  providedIn: 'root'
})
export class EmployeeResolver implements Resolve<Observable<any>> {

  constructor(private adminService: AdminService) {
  }

  resolve(route: ActivatedRouteSnapshot,
          state: RouterStateSnapshot): Observable<Observable<any>> | Promise<Observable<any>> | Observable<any> {
    const id = route.paramMap.get('id');
    if (id) {
      return this.adminService.getUserById(parseInt(id, 10));
    }
    return null;
  }

}
