package fr.efrei.Lab1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car extends Vehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int numberOfSeats;
	
	public Car(){
		super();
	}
	
	public Car(String name, String plate,int seats){
		super(name, plate);
		this.numberOfSeats = seats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public String toString() {
		return "Car [numberOfSeats=" + numberOfSeats + ", id=" + id + "]";
	}

	
	
}
