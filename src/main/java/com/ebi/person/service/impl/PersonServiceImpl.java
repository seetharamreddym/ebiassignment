package com.ebi.person.service.impl;

import static com.ebi.person.util.MarshallingUtil.convertToPersonEntity;
import static com.ebi.person.util.MarshallingUtil.convertToPersonPOJO;
import static com.ebi.person.util.MarshallingUtil.getPersons;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ebi.person.entity.PersonEntity;
import com.ebi.person.exception.ApplicationException;
import com.ebi.person.model.Person;
import com.ebi.person.model.Persons;
import com.ebi.person.repository.PersonRepository;
import com.ebi.person.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Override
	public Persons getAllPersons() {
		Persons result = new Persons();
		result.setPerson(getPersons(personRepository.findAll()));
		return result;
	}

	@Override
	public Person insertPerson(Person person) {
		return convertToPersonPOJO(personRepository.save(convertToPersonEntity(person)));

	}

	@Override
	public Person updatePerson(Person person) {
		return convertToPersonPOJO(personRepository.save(convertToPersonEntity(person)));

	}

	@Override
	public void deletePerson(Long id) {
		Optional<PersonEntity> personEntity = personRepository.findById(id);
		if(!personEntity.isPresent()) {
			throw new ApplicationException(HttpStatus.NOT_FOUND, "Getting person details for delete", "person not found with given id:"+id);
		}
		personRepository.delete(personEntity.get());

	}

	@Override
	public Person getPerson(Long id) {
		Optional<PersonEntity> personEntity = personRepository.findById(id);
		if(!personEntity.isPresent()) {
			throw new ApplicationException(HttpStatus.NOT_FOUND, "Getting person details", "person not found with given id:"+id);
		}
		return convertToPersonPOJO(personEntity.get());
	}

	@Override
	public Persons insertPersons(Persons persons) {
		Persons result = new Persons();
		List<PersonEntity> personEntities = new ArrayList<>();
		persons.getPerson().forEach(person -> personEntities.add(convertToPersonEntity(person)));
		result.setPerson(getPersons(personRepository.saveAll(personEntities)));
		return result;
	}

}
