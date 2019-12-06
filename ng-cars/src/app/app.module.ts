import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddCarComponent } from './add-car/add-car.component';
import { VanService } from './van.service';
import {CarServiceService} from './car-service.service';

@NgModule({
  declarations: [
    AppComponent,
    AddCarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    CarServiceService,
    VanService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
