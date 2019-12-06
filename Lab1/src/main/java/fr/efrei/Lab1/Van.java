package fr.efrei.Lab1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Van extends Vehicule{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int maxWeight;

	public Van() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Van(String name, String plate, int maxWeight) {
		super(name, plate);
		this.maxWeight = maxWeight;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Van [maxWeight=" + maxWeight + ", id=" + id + "]";
	}
	
	
}
