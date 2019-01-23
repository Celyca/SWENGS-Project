import { Component, OnInit } from '@angular/core';
import {Animal} from '../api/animal';
import {Location} from '../api/location';
import {AnimalService} from '../service/animal.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {AdminService} from '../service/admin.service';

@Component({
  selector: 'app-animal-list',
  templateUrl: './animal-list.component.html',
  styleUrls: ['./animal-list.component.scss']
})
export class AnimalListComponent implements OnInit {

  animals: Array<Animal>;
  locations: Array<Location>;
  species: Array<any>;
  admin: boolean;
  animalOptions: Array<Animal>;

  constructor(private animalService: AnimalService,
              private router: Router,
              private route: ActivatedRoute,
              private toastr: ToastrService,
              private adminService: AdminService) {
  }

  ngOnInit() {
    this.animalService.getAll()
      .subscribe((animals: any) => {
        this.animals = animals;
      });

    const data = this.route.snapshot.data;
    this.animalOptions = data.animals;
    this.animals = this.animalOptions;
    this.locations = data.locations;
    this.species = data.species;
    this.admin = this.adminService.isAdmin;
  }

  createAnimal() {
    this.router.navigate(['/animal-form']);
  }

  deleteAnimal(animal: Animal) {
    this.animalService.delete(animal)
      .subscribe(() => {
        this.toastr.error(animal.name + ' wurde gelöscht.', 'SCHADE!');
        this.ngOnInit();
      });
  }

  filerAnimal(input) {
    if (input) {
      this.animals = this.animalOptions.filter(x => {
        return x.name.toLowerCase().indexOf(input.toLowerCase()) !== -1;
      });
    } else {
      this.animals = this.animalOptions;
    }
  }
}
