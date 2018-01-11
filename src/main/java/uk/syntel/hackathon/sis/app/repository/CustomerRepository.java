package uk.syntel.hackathon.sis.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import uk.syntel.hackathon.sis.app.beans.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {

	List<Customer> findAll();

}
