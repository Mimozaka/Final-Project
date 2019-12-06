package fr.efrei.Lab1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long>{

	List<Rent> findById(long id);
}
