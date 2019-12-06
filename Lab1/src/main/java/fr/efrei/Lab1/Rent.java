package fr.efrei.Lab1;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Rent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date beginRent;
	private Date endRent;
	
	@ManyToOne
	private Person person;
	@ManyToOne
	private Vehicule vehicule;
	
	/*private List<Person> persons = new ArrayList<Person>();
	private List<Vehicule> vehicules = new ArrayList<Vehicule>();*/
	
	public Rent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rent(Date beginRent, Date endRent, Person person, Vehicule vehicule) {
		this.beginRent = beginRent;
		this.endRent = endRent;
		this.person = person;
		this.vehicule = vehicule;
	}

	public Date getBeginRent() {
		return beginRent;
	}

	public void setBeginRent(Date beginRent) {
		this.beginRent = beginRent;
	}

	public Date getEndRent() {
		return endRent;
	}

	public void setEndRent(Date endRent) {
		this.endRent = endRent;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Vehicule getVehicule() {
		return vehicule;
	}
	
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	@Override
	public String toString() {
		return "Rent [id=" + id + ", beginRent=" + beginRent + ", endRent=" + endRent + ", person=" + person
				+ ", vehicule=" + vehicule + "]";
	}
	
	
	
}
