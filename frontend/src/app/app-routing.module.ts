import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {MainComponent} from './main/main.component';
import {RegisterComponent} from './register/register.component';
import {AuthGuard} from './guards/auth.guard';
import {AnimalListComponent} from './animal-list/animal-list.component';
import {SpeciesListResolver} from './resolver/speciesList.resolver';
import {LocationListResolver} from './resolver/locationList.resolver';
import {AnimalFormComponent} from './animal-form/animal-form.component';
import {AnimalListResolver} from './resolver/animalList.resolver';
import {AnimalResolver} from './resolver/animal.resolver';
import {LocationListComponent} from './location-list/location-list.component';
import {LocationFormComponent} from './location-form/location-form.component';
import {LocationResolver} from './resolver/location.resolver';

const routes: Routes = [
  {path: '', redirectTo: '/index', pathMatch: 'full'},
  {path: 'index', component: MainComponent, canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},

  // ---------------------------------------------------------------------------------
  // ANIMALS
  // ---------------------------------------------------------------------------------

  {
    path: 'animals', component: AnimalListComponent,
    canActivate: [AuthGuard],
    resolve: {
      animals: AnimalListResolver,
      species: SpeciesListResolver,
      locations: LocationListResolver
    }
  },

  {
    path: 'animal-form', component: AnimalFormComponent,
    canActivate: [AuthGuard],
    resolve: {
      species: SpeciesListResolver,
      locations: LocationListResolver
    }
  },

  // ---------------------------------------------------------------------------------

  {
    path: 'animal-form/:id', component: AnimalFormComponent,
    canActivate: [AuthGuard],
    resolve: {
      animal: AnimalResolver,
      species: SpeciesListResolver,
      locations: LocationListResolver
    }
  },

  // ---------------------------------------------------------------------------------
  // LOCATIONS
  // ---------------------------------------------------------------------------------

  {
    path: 'locations', component: LocationListComponent,
    canActivate: [AuthGuard],
    resolve: {
      locations: LocationListResolver
    }
  },

  {
    path: 'location-form', component: LocationFormComponent,
    canActivate: [AuthGuard],
  },

  // ---------------------------------------------------------------------------------

  {
    path: 'location-form/:id', component: LocationFormComponent,
    canActivate: [AuthGuard],
    resolve: {
      location: LocationResolver
    }
  },

  // ---------------------------------------------------------------------------------
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
