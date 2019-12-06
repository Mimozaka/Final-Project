import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CARS } from './mock-cars'
import { Car } from './car';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarServiceService {

  private rentUrl = 'http://localhost:8080/cars/';

  constructor(private http: HttpClient) { }

  getCars(): Promise<Car[]>{
    return Promise.resolve(CARS);
  }
  
  getCar(plateNumber: string): Promise<Car>{
    return Promise.resolve(CARS.find(car => car.plateNumber==plateNumber));
  }

  getCarsWithObservable(): Observable<any> {
     let obs = this.http.get("http://localhost:8080/cars")
     obs.subscribe((response: Response) => response);
     return obs;
  }

  getCarWithObservable(plateNumber): Observable<any> {
    let obs =this.http.get("http://localhost:8080/cars/"+ plateNumber);
    obs.subscribe((response: Response) => response);
    return obs;
  }

  add_car(car): void{
    CARS.push(car);
    console.log(CARS);
    this.saveCar(car);
  }

  saveCar(car){
    let obs = this.http.post('http://localhost:8080/cars', car);
    obs.subscribe(() => {
      console.log('Voiture créée.');
    })
  }
}