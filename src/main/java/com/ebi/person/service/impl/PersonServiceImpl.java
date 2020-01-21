package com.ebi.person.service.impl;

import static com.ebi.person.util.MarshallingUtil.convertToPersonEntity;
import static com.ebi.person.util.MarshallingUtil.convertToPersonPOJO;
import static com.ebi.person.util.MarshallingUtil.getPersons;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebi.person.entity.PersonEntity;
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

		personRepository.delete(personRepository.findById(id).get());

	}

	@Override
	public Person getPerson(Long id) {
		return convertToPersonPOJO(personRepository.findById(id).get());
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
