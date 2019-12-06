package fr.efrei.Lab1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VanRepository extends CrudRepository<Van,Long>{

	List<Van>findById(String nom);
}
