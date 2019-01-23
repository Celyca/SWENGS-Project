import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AnimalService} from '../service/animal.service';
import {SpeciesService} from '../service/species.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Animal} from '../api/animal';

@Component({
  selector: 'app-animal-form',
  templateUrl: './animal-form.component.html',
  styleUrls: ['./animal-form.component.scss']
})
export class AnimalFormComponent implements OnInit {

  animalForm;
  locationOptions;
  speciesOptions;
  animal: Animal;

  constructor(private animalService: AnimalService,
              private route: ActivatedRoute,
              private router: Router,
              private speciesService: SpeciesService) {
  }

  ngOnInit() {
    this.animalForm = new FormGroup({
      'id': new FormControl(),
      'name': new FormControl('', [Validators.required]),
      'breed': new FormControl('', [Validators.required]),
      'color': new FormControl('', [Validators.required]),
      'age': new FormControl('', [Validators.required]),
      'gender': new FormControl('', [Validators.required]),
      'description': new FormControl('', [Validators.required]),
      'species': new FormControl('', [Validators.required]),
      'location': new FormControl('', [Validators.required]),
      'image': new FormControl(),
    });

    const data = this.route.snapshot.data;
    this.locationOptions = data.locations;
    this.speciesOptions = data.species;
    this.animal = data.animal;
    if (this.animal) {
      this.animalForm.setValue(this.animal);
    }
  }

  saveAnimal() {
    const animal: Animal = this.animalForm.value;
    if (animal.id) {
      this.animalService.update(animal)
        .subscribe((response) => {
          alert('updated successfully');
          this.navigateBack();
        });
    } else {
      this.animalService.create(animal)
        .subscribe((response: any) => {
          alert('created successfully');
          this.navigateBack();
        });
    }
  }

  navigateBack() {
    this.router.navigate(['/animals']);
  }
}
