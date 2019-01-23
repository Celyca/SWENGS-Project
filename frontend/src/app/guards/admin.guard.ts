import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {ToastrService} from 'ngx-toastr';
import {AdminService} from '../service/admin.service';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(private adminService: AdminService,
              private router: Router,
              private toastr: ToastrService) {
  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (!this.adminService.isAdmin) {
      this.router.navigate(['/login']);
      this.toastr.error('Du Schlingel', 'KEIN ZUTRITT!');
      return false;
    }

    return true;
  }
}
