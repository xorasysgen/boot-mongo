package boot.backend.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import boot.backend.mongo.dto.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
	
	public Person findByFirstName(String firstName);
	public List<Person> findByContactNumber(String contactNumber);

}
