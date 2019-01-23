import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserService} from '../service/user.service';
import {Animal} from '../api/animal';
import {AnimalService} from '../service/animal.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  validationForm: FormGroup;
  isLoggedIn: boolean;
  animal: Animal;
  animals: number;


  constructor(private userService: UserService,
              private fb: FormBuilder,
              private  animalService: AnimalService) {
    this.validationForm = fb.group({
      usernameFormEx: [null, [Validators.required, Validators.minLength, Validators.maxLength]],
      passwordFormEx: [null, Validators.required],
      passwordFormEx2: [null, Validators.required]
    });
  }

  ngOnInit() {
    {
      this.isLoggedIn = this.userService.isLoggedIn;
      this.userService.loggedInChange.subscribe((isLoggedIn) => {
        this.isLoggedIn = isLoggedIn;
      });
    }



    this.animalService.count()
      .subscribe((count: any) => {
        this.animals = count;
        this.getAnimal();
      });
  }

  getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min)) + min;
  }

  getAnimal() {
    this.animalService.getById(this.getRandomInt(0, this.animals + 1))
      .subscribe((animal: any) => {
        this.animal = animal;
      });
  }
}
