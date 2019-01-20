import { Component, OnInit } from '@angular/core';
import {LocationService} from '../service/location.service';
import {ActivatedRoute, Router} from '@angular/router';
import {UserProfile} from '../api/profile';
import {User} from '../api/user';
import {UserService} from '../service/user.service';
import {UserProfileService} from '../service/user-profile.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.scss']
})
export class UserprofileComponent implements OnInit {

  user: User;
  locations: Array<Location>;
  userProfile: UserProfile;

  constructor(private userProfileService: UserProfileService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    const data = this.route.snapshot.data;
    this.user = data.user;
    this.locations = data.locations;

    this.userProfileService.getById(this.user.id)
      .subscribe((userProfile: any) => {
        this.userProfile = userProfile;
      });

    if (this.userProfile.firstName === null) {
      this.router.navigate(['/profile-form']);
    }
  }
}
