import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {map} from 'rxjs/operators';
import {JwtHelperService} from '@auth0/angular-jwt';
import {User} from '../api/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  isLoggedIn: boolean;

  loggedInChange: Subject<boolean> = new Subject<boolean>();

  accessTokenLocalStorageKey = 'access_token';

  constructor(private http: HttpClient, private router: Router) {
    this.isLoggedIn = !!localStorage.getItem(this.accessTokenLocalStorageKey);
    this.loggedInChange.subscribe((value) => {
      this.isLoggedIn = value;
    });
  }

  // ---------------------------------------------------------------------------------

  create(user: User) {
    return this.http.post('/api/authentication/users', user);
  }

  update(user: User) {
    return this.http.put('/api/authentication/users/' + user.id, user);
  }

  getAuth() {
    return this.http.get('/api/authentication/auth');
  }

  // ---------------------------------------------------------------------------------

  login(user) {
    return this.http.post('/api/auth/', user, {
      'headers': new HttpHeaders({'Content-Type': 'application/json'}),
      'responseType': 'text',
      observe: 'response'
    }).pipe(map((res: any) => {
      const token = res.headers.get('Authorization').replace(/^Bearer /, '');
      localStorage.setItem(this.accessTokenLocalStorageKey, token);
      const helper = new JwtHelperService();
      console.log(helper.decodeToken(token));
      this.loggedInChange.next(true);
      this.router.navigate(['/index']);
      return res;
    }));
  }


  logout() {
    localStorage.removeItem(this.accessTokenLocalStorageKey);
    this.loggedInChange.next(false);
    this.router.navigate(['/login']);
  }

}
