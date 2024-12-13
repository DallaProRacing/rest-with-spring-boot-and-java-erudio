package br.com.dallapro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dallapro.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

}
