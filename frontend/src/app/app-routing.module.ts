import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
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
import {OfferListComponent} from './offer-list/offer-list.component';
import {OfferFormComponent} from './offer-form/offer-form.component';
import {OfferListResolver} from './resolver/offerList.resolver';
import {OfferResolver} from './resolver/offer.resolver';
import {EmployeeListResolver} from './resolver/employeeList.resolver';
import {UserListComponent} from './user-list/user-list.component';
import {UserListResolver} from './resolver/userList.resolver';
import {UserprofileComponent} from './userprofile/userprofile.component';
import {UserprofileFormComponent} from './userprofile-form/userprofile-form.component';
import {AuthResolver} from './resolver/auth.resolver';
import {CalendarComponent} from './calendar/calendar.component';
import {EventListResolver} from './resolver/eventList.resolver';
import {CreditsComponent} from './credits/credits.component';
import {AdminGuard} from './guards/admin.guard';

const routes: Routes = [
  {path: '', redirectTo: '/index', pathMatch: 'full'},
  {path: 'index', component: MainComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'credits', component: CreditsComponent},

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
    canActivate: [AdminGuard],
    resolve: {
      species: SpeciesListResolver,
      locations: LocationListResolver
    }
  },

  // ---------------------------------------------------------------------------------

  {
    path: 'animal-form/:id', component: AnimalFormComponent,
    canActivate: [AdminGuard],
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
    canActivate: [AdminGuard],
  },

  // ---------------------------------------------------------------------------------

  {
    path: 'location-form/:id', component: LocationFormComponent,
    canActivate: [AdminGuard],
    resolve: {
      location: LocationResolver
    }
  },

  // ---------------------------------------------------------------------------------
  // OFFERS
  // ---------------------------------------------------------------------------------

  {
    path: 'offers', component: OfferListComponent,
    canActivate: [AuthGuard],
    resolve: {
      offers: OfferListResolver,
      species: SpeciesListResolver,
      locations: LocationListResolver,
      employees: EmployeeListResolver,
    }
  },

  {
    path: 'offer-form', component: OfferFormComponent,
    canActivate: [AdminGuard],
    resolve: {
      species: SpeciesListResolver,
      locations: LocationListResolver,
      employees: EmployeeListResolver,
    }
  },

  // ---------------------------------------------------------------------------------

  {
    path: 'offer-form/:id', component: OfferFormComponent,
    canActivate: [AdminGuard],
    resolve: {
      offer: OfferResolver,
      species: SpeciesListResolver,
      locations: LocationListResolver,
      employees: EmployeeListResolver,
    }
  },

  // ---------------------------------------------------------------------------------
  // EVENTS
  // ---------------------------------------------------------------------------------

  {
    path: 'calendar', component: CalendarComponent,
    canActivate: [AuthGuard],
    resolve: {
      events: EventListResolver,
      offers: OfferListResolver,
      animals: AnimalListResolver,
      user: AuthResolver,
      locations: LocationListResolver,
    }
  },

  // ---------------------------------------------------------------------------------
  // USERS
  // ---------------------------------------------------------------------------------

  {
    path: 'admin/users', component: UserListComponent,
    canActivate: [AdminGuard],
    resolve: {
      users: UserListResolver,
    }
  },

  // ---------------------------------------------------------------------------------

  {
    path: 'profile', component: UserprofileComponent,
    canActivate: [AuthGuard],
    resolve: {
      user: AuthResolver,
      locations: LocationListResolver,
    }
  },

  {
    path: 'profile-form', component: UserprofileFormComponent,
    canActivate: [AuthGuard],
    resolve: {
      user: AuthResolver,
      locations: LocationListResolver,
    }
  },

  // ---------------------------------------------------------------------------------
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
