import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {UserService} from '../service/user.service';
import {ToastrService} from 'ngx-toastr';


@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private userService: UserService,
              private router: Router,
              private toastr: ToastrService) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (!this.userService.isLoggedIn) {
      this.router.navigate(['/login']);
      this.toastr.warning('Bitte logge dich zuerst ein oder registriere dich.', 'OOOPS!');
      return false;
    }

    return true;
  }
}
