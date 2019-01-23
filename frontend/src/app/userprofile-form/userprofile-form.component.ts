import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserProfileService} from '../service/user-profile.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {User} from '../api/user';
import {DatePipe} from '@angular/common';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-userprofile-form',
  templateUrl: './userprofile-form.component.html',
  styleUrls: ['./userprofile-form.component.scss'],
  providers: [DatePipe]
})
export class UserprofileFormComponent implements OnInit {

  profileForm;
  locationOptions;
  user: User;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private userProfileService: UserProfileService,
              private datePipe: DatePipe,
              private toastr: ToastrService) { }

  ngOnInit() {
    this.profileForm = new FormGroup({
      'id': new FormControl(),
      'username': new FormControl(),
      'firstName': new FormControl('', [Validators.required]),
      'lastName': new FormControl('', [Validators.required]),
      'dayOfBirth': new FormControl('', [Validators.required]),
      'email': new FormControl('', [Validators.required]),
      'zip': new FormControl('', [Validators.required]),
      'city': new FormControl('', [Validators.required]),
      'address': new FormControl('', [Validators.required]),
      'phone': new FormControl('', [Validators.required]),
      'locations': new FormControl(),
      'image': new FormControl(),
    });

    const data = this.route.snapshot.data;
    this.locationOptions = data.locations;
    this.user = data.user;

    this.userProfileService.getById(this.user.id)
      .subscribe((userProfile: any) => {
        const profile = userProfile;
        profile.dayOfBirth = this.datePipe.transform(profile.dayOfBirth, 'yyyy-MM-dd');
        this.profileForm.setValue(profile);
      });


  }

  saveUser() {
    const user = this.profileForm.value;
    this.userProfileService.update(user)
      .subscribe((response) => {
        this.toastr.success('Profil wurde aktualisiert.', 'ERFOLG!');
        this.navigateBack();
      });
  }

  navigateBack() {
    this.router.navigate(['/profile']);
  }
}
