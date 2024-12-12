package br.com.dallapro.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.dallapro.model.Person;

@Service
public class PersonServices {
	  private final AtomicLong counter = new AtomicLong();
	  private Logger logger = Logger.getLogger(PersonServices.class.getName());

	  
	  public Person create(Person person) {
	  
		  logger.info("Creating one person!");
		  return person;
	  }
	  
	  
	  public Person update(Person person) {		  
		  logger.info("Updating one person!");
		  return person;
	  }
	  
	  public void delete(String id) {		  
		  logger.info("Deleting one person!");		  
	  }
	  
	  
	  
	  public List<Person> findAll(){
		  
		  logger.info("Finding all people!");
		  List<Person> persons = new ArrayList<>();
		  for (int i = 0; i < 8; i++) {
			Person persson = mckPerson(i);
			persons.add(persson);
		}
		return persons ;
	  }

	public Person findById (String id) {	
		
		  logger.info("Finding one person");
		  Person person = new Person();
		  person.setId(counter.incrementAndGet());
		  person.setFirstName("Ruan");
		  person.setLasttName("Dalla Rosa");
		  person.setAddress("Barra");
		  person.setGener("Male");
		  return person;		  		  
	  }
	  
	 private Person mckPerson(int i) {
		 
		  Person person = new Person();
		  person.setId(counter.incrementAndGet());
		  person.setFirstName("Person name"+ i);
		  person.setLasttName("Last name" + i);
		  person.setAddress("Some address in Brasil" + i);
		  person.setGener("Male");
		  return person;		
		}
}
