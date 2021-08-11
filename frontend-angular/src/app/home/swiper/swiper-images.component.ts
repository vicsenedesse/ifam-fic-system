import { Component, ViewEncapsulation, ViewChild } from "@angular/core";
import { SwiperComponent } from "swiper/angular";

// import Swiper core and required modules
import SwiperCore, { Pagination } from "swiper/core";

// install Swiper modules
SwiperCore.use([Pagination]);

@Component({
  selector: "app-swiper",
  templateUrl: './swiper-images.component.html',
  styleUrls: ["./swiper-images.component.scss"],
  // encapsulation: ViewEncapsulation.None,
})
export class SwiperImagesComponent {}
