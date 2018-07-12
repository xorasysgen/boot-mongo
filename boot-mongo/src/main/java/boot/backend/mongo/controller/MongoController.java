package boot.backend.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import boot.backend.mongo.dto.Person;
import boot.backend.mongo.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class MongoController {
	
	@Autowired
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping("/create")
	@ResponseBody
	public Person create(@RequestBody Person person) {
		if(person!=null) {
		return personService.create(person);
		}
		else
			return null;
		
	}
	
	
	@GetMapping("/getall")
	@ResponseBody
	public List<Person> getAllPerson() {
		return personService.getAllPersons();
		
	}

}

