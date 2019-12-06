package fr.efrei.Lab1;

import java.util.*;

import javax.persistence.*;

@Entity
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String plateNumber;
	
	private ArrayList<Rent> rent = new ArrayList<Rent>();
		
	public Vehicule(){
		super();
	}
	
	public Vehicule (String name, String plateNum){
		super();
		this.name = name;
		this.plateNumber = plateNum;
	}

	public long getId(){
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plate) {
		this.plateNumber = plate;
	}
	
	//@ManyToOne
	@OneToMany(mappedBy="vehicule", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	public ArrayList<Rent> getRent() {
		return rent;
	}

	public void setRent(ArrayList<Rent> rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", name=" + name + ", plateNumber=" + plateNumber + ", rent=" + rent + "]";
	}	
}
