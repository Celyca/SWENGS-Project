import {Component, OnInit} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {UserService} from '../service/user.service';
import {User} from '../api/user';
import {UserProfileService} from '../service/user-profile.service';
import {UserProfile} from '../api/profile';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  clicked: boolean;
  isLoggedIn: boolean;
  user: User;
  userProfile: UserProfile;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(private userService: UserService,
              private breakpointObserver: BreakpointObserver,
              private userProfileService: UserProfileService) {
    this.clicked = this.clicked === undefined ? false : true;
  }

  ngOnInit() {
    this.isLoggedIn = this.userService.isLoggedIn;
    this.userService.loggedInChange.subscribe((isLoggedIn) => {
      this.isLoggedIn = isLoggedIn;
      if (this.isLoggedIn) {
        this.getUser();
      }
    });
    this.getUser();
  }

  getUser() {
    if (this.isLoggedIn) {
      this.userService.getAuth().subscribe((user: any) => {
        this.user = user;
        this.userProfileService.getById(this.user.id).subscribe((userProfile: any) => {
          this.userProfile = userProfile;
        });
      });
    }
  }
  logout() {
    this.userService.logout();
  }

  setClicked(val: boolean): void {
    this.clicked = val;
  }


}
