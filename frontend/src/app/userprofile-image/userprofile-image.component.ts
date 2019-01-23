import {Component, ElementRef, forwardRef, OnInit} from '@angular/core';
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from '@angular/forms';
import {FileItem, FileUploader, ParsedResponseHeaders} from 'ng2-file-upload';
import {UserImage} from '../api/userImage';
import {UserService} from '../service/user.service';
import {HttpClient} from '@angular/common/http';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-userprofile-image',
  templateUrl: './userprofile-image.component.html',
  styleUrls: ['./userprofile-image.component.scss'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => UserprofileImageComponent),
      multi: true
    }
  ]
})
export class UserprofileImageComponent implements OnInit, ControlValueAccessor {
  name: string;
  uploader: FileUploader;
  resourceUrl = '/api/dto/user/image';
  userImage: UserImage;
  preview;

  onChange = (userImage: UserImage) => {
    // empty default
  }

  constructor(private userService: UserService,
              private http: HttpClient,
              private elm: ElementRef,
              private toastr: ToastrService) {
    this.name = elm.nativeElement.getAttribute('name');
  }

  ngOnInit() {
    this.uploader = new FileUploader({
      url: this.resourceUrl,
      authToken: 'Bearer ' + localStorage.getItem(this.userService.accessTokenLocalStorageKey),
      autoUpload: true
    });


    this.uploader.onBeforeUploadItem = (item: FileItem) => {
      this.userImage = {
        contentType: item.file.type,
        originalFileName: item.file.name,
        size: item.file.size
      };
      this.toastr.info('Bild wird hochgeladen.', 'IN ARBEIT!');
    };

    this.uploader.onSuccessItem = (item: FileItem, response: string, status: number, headers: ParsedResponseHeaders) => {
      const uploadedMedia = <UserImage>JSON.parse(response);
      if (!this.userImage.id && this.userImage.originalFileName === uploadedMedia.originalFileName) {
        this.userImage.id = uploadedMedia.id;
        this.onChange(this.userImage);
        this.initPreviews();
        this.toastr.success('Bild hochgeladen.', 'ERFOLG!');
      }
    };
  }

  // ---------------------------------------------------------------------------------

  initPreviews() {
    if (this.userImage) {
      this.http.get(`${this.resourceUrl}/${this.userImage.id}`, {responseType: 'blob'}).subscribe((blob: Blob) => {
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
    this.userImage = {
      id: obj
    };
    this.onChange(obj);
    this.initPreviews();
  }

}
