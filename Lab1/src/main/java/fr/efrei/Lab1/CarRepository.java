package fr.efrei.Lab1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository <Car, Long> {

	List<Car> findByName(String nom);

}
