import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserService} from './user.service';
import {User} from '../api/user';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  isAdmin: boolean;
  isEmployee: boolean;

  constructor(private http: HttpClient, private userService: UserService) {
    this.userService.getAuth()
      .subscribe((response: any) => {
        const user: User = response;
        this.isAdmin = user.admin;
        this.isEmployee = user.employee;
      });
  }

  // ---------------------------------------------------------------------------------

  getAllEmployees() {
    return this.http.get('/api/dto/users/employee/');
  }

  getAllUsers() {
    return this.http.get('/api/dto/admin/users');
  }

  getUserById(id: number) {
    return this.http.get('/api/dto/admin/users/'  + id);
  }

  deleteUser(id: number) {
    return this.http.delete('/api/dto/admin/users/'  + id);
  }

  // ---------------------------------------------------------------------------------
}
