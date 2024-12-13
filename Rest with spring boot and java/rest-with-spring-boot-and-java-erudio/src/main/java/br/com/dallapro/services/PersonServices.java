package br.com.dallapro.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dallapro.data.vo.v1.PersonVo;
import br.com.dallapro.data.vo.v2.PersonVoV2;
import br.com.dallapro.exceptions.ResouseNotFoundException;
import br.com.dallapro.mapper.Mapper;
import br.com.dallapro.mapper.custom.PersonMapper;
import br.com.dallapro.model.Person;
import br.com.dallapro.repositories.PersonRepository;

@Service
public class PersonServices {
	 
	  private Logger logger = Logger.getLogger(PersonServices.class.getName());

	  
	  @Autowired
	  PersonRepository repository;
	  
	  @Autowired
	  PersonMapper mapper;
	  
	  public PersonVo create(PersonVo person) {	  
		  logger.info("Creating one person!");
		  var entity = Mapper.parseObject(person, Person.class);
		  var vo = Mapper.parseObject(repository.save(entity),PersonVo.class);
		  return vo;
	  }
	  public PersonVoV2 createV2(PersonVoV2 person) {	  
		  logger.info("Creating one person V2!");
		  var entity = mapper.convertVoToEntity(person);
		  var vo = mapper.convertEntityToVo(repository.save(entity));
		  return vo;
	  }
	  
	  
	  public PersonVo update(PersonVo person) {		  
		  logger.info("Updating one person!");
		  var entity = repository.findById(person.getId())
				  .orElseThrow(()-> new ResouseNotFoundException("No records found for this ID!!!"));		  		  
		 
		  entity.setFirstName(person.getFirstName());
		  entity.setLastName(person.getLastName());
		  entity.setAddress(person.getAddress());
		  entity.setGender(person.getGender());		  
		  var vo = Mapper.parseObject(repository.save(entity),PersonVo.class);
		  return vo;
	  }
	  	  
	  public void delete(Long id) {		  
		  logger.info("Deleting one person!");
		  var entity = repository.findById(id)
				  .orElseThrow(()-> new ResouseNotFoundException("No records found for this ID!!!"));		  		  
		repository.delete(entity);	 
	  }  
	  
	  
	  public List<PersonVo> findAll(){		  
		logger.info("Finding all people!");		  		  
		return Mapper.parseListObjects(repository.findAll(), PersonVo.class);
	  }

	public PersonVo findById (Long id) {		
		  logger.info("Finding one person");		  
		  var entity = repository.findById(id)
				  .orElseThrow(()-> new ResouseNotFoundException("No records found for this ID!!!"));		  		  
	return Mapper.parseObject(entity, PersonVo.class);  
	}
	  
}
