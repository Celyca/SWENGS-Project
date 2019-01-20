import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AdminService} from '../service/admin.service';
import {User} from '../api/user';
import {UserService} from '../service/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  users: Array<User>;

  constructor(private adminService: AdminService,
              private router: Router,
              private route: ActivatedRoute,
              private userService: UserService) { }

  ngOnInit() {
    this.adminService.getAllUsers()
      .subscribe((users: any) => {
        this.users = users;
      });

    const data = this.route.snapshot.data;
    this.users = data.users;
  }

  deleteUser(user: User) {
    this.adminService.deleteUser(user.id)
      .subscribe(() => {
        this.ngOnInit();
      });
  }

  toAdmin(user: User) {
    if (user.admin) {
      user.admin = false;
    } else {
      user.admin = true;
    }
    this.updateUser(user);
  }

  toEmployee(user: User) {
    if (user.employee) {
      user.employee = false;
    } else {
      user.employee = true;
    }
    this.updateUser(user);
  }

  updateUser(user: User) {
    this.userService.update(user).subscribe(
      this.ngOnInit
    );
  }
}
