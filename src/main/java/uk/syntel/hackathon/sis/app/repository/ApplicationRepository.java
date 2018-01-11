package uk.syntel.hackathon.sis.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import uk.syntel.hackathon.sis.app.beans.Application;

@Repository
public interface ApplicationRepository extends MongoRepository<Application, Long> {

	List<Application> findAll();
	
}
