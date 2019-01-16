import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AnimalService} from '../service/animal.service';
import {SpeciesService} from '../service/species.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-animal-form',
  templateUrl: './animal-form.component.html',
  styleUrls: ['./animal-form.component.scss']
})
export class AnimalFormComponent implements OnInit {

  animalForm;
  locationOptions;
  speciesOptions;

  constructor(private animalService: AnimalService,
              private route: ActivatedRoute,
              private router: Router,
              private speciesService: SpeciesService) {
  }

  ngOnInit() {
    this.animalForm = new FormGroup({
      'id': new FormControl(),
      'name': new FormControl(),
      'breed': new FormControl(),
      'color': new FormControl(),
      'age': new FormControl(),
      'gender': new FormControl(),
      'description': new FormControl(),
      'species': new FormControl(),
      'location': new FormControl(),
    });

    const data = this.route.snapshot.data;
    this.locationOptions = data.locations;
    this.speciesOptions = data.species;
    const animal = data.animal;
    if (animal) {
      this.animalForm.setValue(animal);
    }
  }

  saveAnimal() {
    const animal = this.animalForm.value;
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
