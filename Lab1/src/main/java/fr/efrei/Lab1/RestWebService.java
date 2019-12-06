package fr.efrei.Lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class RestWebService {
	
	VehiculeRepository vehiculeRepository;
	PersonRepository personRepository;
	RentRepository rentRepository;
	
	
	@Autowired(required = true)
	public RestWebService(VehiculeRepository vehiculeRepository, PersonRepository personRepository, RentRepository rentRepository)
	{
		super();
		this.vehiculeRepository = vehiculeRepository;
		this.personRepository = personRepository;
		this.rentRepository = rentRepository;
	}
	
	@GetMapping("/Vehicules")
	public Iterable<Vehicule> getVehicule(){
		return vehiculeRepository.findAll();
	}
	
	@GetMapping("/Persons")
	public Iterable<Person> getPerson(){
		return personRepository.findAll();
	}
	
	@GetMapping("/Rents")
	public Iterable<Rent> getRent(){
		return rentRepository.findAll();
	}
}
