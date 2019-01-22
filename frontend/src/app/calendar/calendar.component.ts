import {Component, OnInit, ViewChild} from '@angular/core';
import { Options } from 'fullcalendar';
import {ActivatedRoute, Router} from '@angular/router';
import {EventService} from '../service/event.service';
import {Event} from '../api/event';
import {Offer} from '../api/offer';
import {Animal} from '../api/animal';
import {FormControl, FormGroup} from '@angular/forms';
import {User} from '../api/user';
import { DatePipe } from '@angular/common';
import {UserProfileService} from '../service/user-profile.service';
import {UserProfile} from '../api/profile';
import {Location} from '../api/location';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss'],
  providers: [DatePipe]
})


export class CalendarComponent implements OnInit {

  entryList: Array<Event>;
  clickedDay: Date;
  offerOptions: Array<Offer>;
  animalOptions: Array<Animal>;
  locationOptions: Array<Location>;
  offerAnimals: Array<Animal>;
  eventForm;
  booking: boolean;
  user: User;
  modal;

  entries = [
    {
      title: 'Test Event',
      start: '2019-01-11',
      allDay: true
    }
  ];

  calendarOptions: Options;
  @ViewChild(CalendarComponent) ucCalendar: CalendarComponent;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private eventService: EventService,
              private datePipe: DatePipe,
              private userProfileService: UserProfileService) {}

  ngOnInit() {
    const result = this.route.snapshot.data;
    this.entryList = result.events;
    this.offerOptions = result.offers;
    this.animalOptions = result.animals;
    this.locationOptions = result.locations;
    this.booking = result.booking;
    this.user = result.user;
    this.convert();

    this.eventForm = new FormGroup({
      'id': new FormControl(''),
      'description': new FormControl(''),
      'event': new FormControl(),
      'animal': new FormControl(),
      'user': new FormControl(this.user.id),
      'offer': new FormControl(),
    });
    this.initCal();
  }

  initCal() {
    this.calendarOptions = {
      editable: false,
      eventLimit: false,
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,basicWeek,basicDay,listYear'
      },
      events: this.entries
    };
  }

  clickDay(event) {
    this.clickedDay = event.date._d;
    this.eventForm.controls.event.setValue(this.clickedDay);
  }

  clickEvent(event) {

    const clickedEventDate = this.datePipe.transform(event.event.start._d, 'yyyy-MM-dd');
    const clickedEvent: Event = this.entryList.find(x => this.datePipe.transform(x.event, 'yyyy-MM-dd') === clickedEventDate);
    const modalOffer: Offer = this.offerOptions.find(x => x.id === clickedEvent.offer);
    const modalAnimal: Animal = this.animalOptions.find(x => x.id === clickedEvent.animal);
    const modalLocation: Location = this.locationOptions.find(x => x.id === modalOffer.location);
    this.userProfileService.getById(modalOffer.user)
      .subscribe((userProfile: UserProfile) => {
        this.modal = {
          date: clickedEventDate,
          description: modalOffer.description,
          animalName: modalAnimal.name,
          animalSpecies: modalAnimal.species,
          animalId: modalAnimal.id,
          employeeFirstName: userProfile.firstName,
          employeeLastName: userProfile.lastName,
          employeeId: userProfile.id,
          duration: modalOffer.duration,
          location: modalLocation
        };
      });
  }

  convert() {
    if (this.entryList != null) {
      this.entryList.forEach(x => {
        this.entries.push(
          {
            title: x.description.toString(),
            start: x.event.toString(),
            allDay: true
          });
      });
    }
  }

  change(input) {
    const result = this.offerOptions.find(offer => offer.id === input);
    this.offerAnimals = this.animalOptions.filter(animal => animal.location === result.id && animal.species === result.species);
  }

  saveEvent() {
    const event = this.eventForm.value;
    this.eventService.create(event)
      .subscribe((response: any) => {
        alert('created successfully');
        this.ngOnInit();
      });
    this.router.navigate(['/calendar']);
  }
}
