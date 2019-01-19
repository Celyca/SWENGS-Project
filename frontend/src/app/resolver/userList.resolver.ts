import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {AdminService} from '../service/admin.service';

@Injectable({
  providedIn: 'root'
})
export class UserListResolver implements Resolve<Observable<any>> {

  constructor(private adminService: AdminService) {
  }

  resolve(route: ActivatedRouteSnapshot,
          state: RouterStateSnapshot): Observable<Observable<any>> | Promise<Observable<any>> | Observable<any> {
    return this.adminService.getAllUsers();
  }
}
