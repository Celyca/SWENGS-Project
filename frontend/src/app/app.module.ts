import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {JwtModule} from '@auth0/angular-jwt';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import { MainComponent } from './main/main.component';
import {
  MatButtonModule,
  MatExpansionModule,
  MatIconModule,
  MatListModule,
  MatSelectModule,
  MatSidenavModule,
  MatToolbarModule
} from '@angular/material';
import {LayoutModule} from '@angular/cdk/layout';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NavComponent } from './nav/nav.component';
import { RegisterComponent } from './register/register.component';
import {AnimalListComponent} from './animal-list/animal-list.component';
import {AnimalFormComponent} from './animal-form/animal-form.component';
import {NgxSelectModule} from 'ngx-select-ex';
import { AnimalImageComponent } from './animal-image/animal-image.component';
import {FileUploadModule} from 'ng2-file-upload';
import {SafeUrlPipe} from './pipe/SafeUrlPipe';
import {ImagePipe} from './pipe/ImagePipe';
import { LocationListComponent } from './location-list/location-list.component';
import { LocationFormComponent } from './location-form/location-form.component';
import { OfferListComponent } from './offer-list/offer-list.component';
import { OfferFormComponent } from './offer-form/offer-form.component';
import {UserListComponent} from './user-list/user-list.component';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { UserprofileFormComponent } from './userprofile-form/userprofile-form.component';
import { UserprofileImageComponent } from './userprofile-image/userprofile-image.component';
import {FullCalendarModule} from 'ng-fullcalendar';
import { CalendarComponent } from './calendar/calendar.component';
import {ToastrModule} from 'ngx-toastr';
import {CommonModule} from '@angular/common';
import { CreditsComponent } from './credits/credits.component';

export function tokenGetter() {
  return localStorage.getItem('access_token');
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainComponent,
    NavComponent,
    RegisterComponent,
    AnimalListComponent,
    AnimalFormComponent,
    AnimalImageComponent,
    SafeUrlPipe,
    ImagePipe,
    LocationListComponent,
    LocationFormComponent,
    OfferListComponent,
    OfferFormComponent,
    UserListComponent,
    UserprofileComponent,
    UserprofileFormComponent,
    UserprofileImageComponent,
    CalendarComponent,
    CreditsComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MDBBootstrapModule.forRoot(),
    BrowserAnimationsModule,
    LayoutModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatSelectModule,
    NgxSelectModule,
    MatExpansionModule,
    FileUploadModule,
    FullCalendarModule,
    ToastrModule.forRoot(),
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter,
        whitelistedDomains: ['localhost:4200']
      }
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
