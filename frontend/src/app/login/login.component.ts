import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {UserService} from '../service/user.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  user: any;

  constructor(private http: HttpClient,
              private router: Router,
              private userService: UserService,
              private toastr: ToastrService) {
  }

  ngOnInit() {
    this.user = {
      username: '',
      password: ''
    };
  }

  login() {
    this.userService.login(this.user)
      .subscribe((res: any) => {
      }, (error) => {
        this.toastr.error('Passwort oder Benutzername sind falsch.', 'OOOPS!');
      });
  }

  register() {
    this.router.navigate(['/register']);
  }
}
