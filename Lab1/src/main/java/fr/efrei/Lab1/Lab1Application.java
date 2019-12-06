	package fr.efrei.Lab1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mockito.runners.VerboseMockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab1Application {

	private static final Logger log = LoggerFactory.getLogger(Lab1Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(RentRepository rentRepository, VehiculeRepository vehiculeRepository, PersonRepository personRepository){
		return (args) -> {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse("2018-10-19");
			log.info(date.toString());
			
			Date dateRetour = dateFormat.parse("2018-11-19");
			log.info(dateRetour.toString());
			
			Car peugeot = new Car("206","AA111AA",5);
			Vehicule renault = new Car("Laguna","AA000AA",5);
			Vehicule seat = new Car("Ibiza", "BB000BB",2);
			Vehicule trafic = new Van("Kangoo","KK111KK",1200);
			Vehicule porsche = new Car("Panamera","99DDD99",2);
			
			renault = vehiculeRepository.save(renault);
			seat = vehiculeRepository.save(seat);
			peugeot = vehiculeRepository.save(peugeot);
			trafic = vehiculeRepository.save(trafic);
			porsche = vehiculeRepository.save(porsche);
			
			Person jean = new Person("Jean", 19);
			Person Lionel = new Person("Lionel",31);
			Person Jeremy = new Person("Jeremy",32);
			Person Dario = new Person("Dario", 27);
			
			/*jean.RentVehicule(peugeot, date, date);
			Lionel.RentVehicule(porsche, date, dateRetour);
			Jeremy.RentVehicule(trafic, date, dateRetour);
			Dario.RentVehicule(seat, date, dateRetour);*/
			
			jean = personRepository.save(jean);
			Lionel = personRepository.save(Lionel);
			Jeremy = personRepository.save(Jeremy);
			Dario = personRepository.save(Dario);
			
			Rent location = new Rent(date, dateRetour, jean, peugeot);
			Rent Location_Jeremy = new Rent(date, dateRetour, Jeremy, trafic);
			Rent Location_Dario = new Rent(date, dateRetour, Dario, seat);
			Rent Location_Lionel = new Rent(date, dateRetour, Lionel, porsche);
			
			location.getPerson().getName();
			location.getVehicule().getName();
			
			location = rentRepository.save(location);
			Location_Jeremy = rentRepository.save(Location_Jeremy);
			Location_Dario = rentRepository.save(Location_Dario);
			Location_Lionel = rentRepository.save(Location_Lionel);
			
			log.info("Location found with findAll():");
			log.info("-------------------------------");
			for (Rent rent : rentRepository.findAll()) {
				log.info(rent.toString());
			}
			log.info("Get all vehicule :");
			log.info("------------------------------");
			vehiculeRepository.findAll().forEach(vehicule -> {
				log.info(vehicule.toString());
			});
			
			log.info("Get all Person :");
			log.info("------------------------------");
			personRepository.findAll().forEach(person -> {
				log.info(person.toString());
			});
			
			log.info("");
			log.info("--------------------------------------------");
			rentRepository.findAll().forEach(rent -> {
				log.info(rent.toString());
			
		});
	
		
	};

}}
