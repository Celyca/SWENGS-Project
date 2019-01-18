import {Component, ElementRef, forwardRef, Input, OnInit} from '@angular/core';
import {ControlValueAccessor, FormGroup, NG_VALUE_ACCESSOR} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {FileItem, FileUploader, ParsedResponseHeaders} from 'ng2-file-upload';
import {UserService} from '../service/user.service';
import {AnimalImage} from '../api/animalImage';

@Component({
  selector: 'app-animal-image',
  templateUrl: './animal-image.component.html',
  styleUrls: ['./animal-image.component.scss'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => AnimalImageComponent),
      multi: true
    }
  ]
})
export class AnimalImageComponent implements OnInit, ControlValueAccessor {
  name: string;
  uploader: FileUploader;
  resourceUrl = '/api/dto/animals/image';
  animalImage: AnimalImage;
  preview;

  onChange = (animalImage: AnimalImage) => {
    // empty default
  }

  constructor(private userService: UserService,
              private http: HttpClient,
              private elm: ElementRef) {
    this.name = elm.nativeElement.getAttribute('name');
  }

  ngOnInit() {
    this.uploader = new FileUploader({
      url: this.resourceUrl,
      authToken: 'Bearer ' + localStorage.getItem(this.userService.accessTokenLocalStorageKey),
      autoUpload: true
    });


    this.uploader.onBeforeUploadItem = (item: FileItem) => {
      this.animalImage = {
        contentType: item.file.type,
        originalFileName: item.file.name,
        size: item.file.size
      };
    };

    this.uploader.onSuccessItem = (item: FileItem, response: string, status: number, headers: ParsedResponseHeaders) => {
      const uploadedMedia = <AnimalImage>JSON.parse(response);
      if (!this.animalImage.id && this.animalImage.originalFileName === uploadedMedia.originalFileName) {
        this.animalImage.id = uploadedMedia.id;
        this.onChange(this.animalImage);
        this.initPreviews();
      }
    };
  }

  // ---------------------------------------------------------------------------------

  initPreviews() {
    if (this.animalImage) {
      this.http.get(`${this.resourceUrl}/${this.animalImage.id}`, {responseType: 'blob'}).subscribe((blob: Blob) => {
        const fileURL = URL.createObjectURL(blob);
        this.preview = fileURL;
      });
    }
  }

  registerOnChange(fn: any): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: any): void {
  }

  setDisabledState(isDisabled: boolean): void {
  }

  writeValue(obj: any): void {
    this.animalImage = {
      id: obj
    };
    this.onChange(obj);
    this.initPreviews();
  }

}
