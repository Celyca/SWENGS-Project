import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  user: any;
  validationForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.validationForm = fb.group({
      usernameFormEx: [null, [Validators.required, Validators.minLength, Validators.maxLength]],
      passwordFormEx: [null, Validators.required],
      passwordFormEx2: [null, Validators.required]
    });
  }

  ngOnInit() {
    this.user = {
      username: '',
      password: ''
    };
  }

}
