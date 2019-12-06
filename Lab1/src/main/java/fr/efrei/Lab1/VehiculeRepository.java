package fr.efrei.Lab1;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends CrudRepository<Vehicule, Long>{
	Optional<Vehicule> findById(Long id);
}
