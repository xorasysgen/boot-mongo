package boot.backend.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.backend.mongo.dto.Person;
import boot.backend.mongo.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	
	public Person create(Person person) {
		return personRepository.save(person);
		
	}
	
	public List<Person> getAllPersons(){
		return personRepository.findAll();
		
	} 
	
	

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}


	

}
