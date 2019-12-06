import { Component, OnInit } from '@angular/core';
import { CarServiceService } from '../car-service.service';
import { Car } from '../car';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-add-car',
  templateUrl: './add-car.component.html',
  styleUrls: ['./add-car.component.css']
})

export class AddCarComponent implements OnInit {
  
  car : Car = {
    brand:'',
    plateNumber:'',
    numberOfSeats: null,
    rented:false,
  }
  cars : Car[]; 
  response : any;
  resp: any;
  carPlate: string = "";
  constructor(
    private carService: CarServiceService,
    private http: HttpClient) {
    }
    
    httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

  ngOnInit() {
    //this.carService.getCars().then((cars)=> this.cars = cars);
    this.carService.getCarsWithObservable().subscribe(
      res => {
        this.cars = res;
      }
    );
  }
  createCar(car)
  {
    this.carService.add_car(car);
  }

  find(){
    this.http.get("http://localhost:8080/cars/")
    .subscribe((resp) => {
      this.resp = resp;
    })
  }

  findByPlate(){
    this.http.get('http://localhost:8080/cars/' + this.carPlate)
    .subscribe((response) => {
      this.response = response;
      console.log(this.response)
    })
  }
}
		
