package fr.efrei.Lab1;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int age;
	
	private ArrayList<Rent> rentList = new ArrayList<Rent>();
	
	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Rent RentVehicule(Vehicule vehicule,Date startDate, Date endDate)
	{
		Rent rent = new Rent(startDate,endDate,this,vehicule);
		setRent(rent);
		return rent;
	}

	public long getId() {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@OneToMany
	(targetEntity = Rent.class, mappedBy="person", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	public ArrayList<Rent> getRent() {
		return rentList;
	}

	public void setRent(Rent rent) {
		this.rentList.add(rent);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", rent=" + rentList.toString() + "]";
	}
	
	
	
}
