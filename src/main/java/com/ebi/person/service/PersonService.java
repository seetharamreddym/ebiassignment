package com.ebi.person.service;


import com.ebi.person.model.Person;
import com.ebi.person.model.Persons;

/**
 * @author srmaila
 *
 * This is the person service interface supporting basic crud operations on person
 */
public interface PersonService {

	
	 
	/**
	 * @return it will return all persons stored in database.
	 */
	Persons getAllPersons();
	 
	/**
	 * it will insert given person into the database
	 * @return  returns the resulted entity converted to normal POJO. .
	 */
	Person insertPerson(Person person);
	
	/**
	 * it will update a given person 
	 * @return  returns the updated entity converted to normal POJO. .
	 */

	Person updatePerson(Person person);

	/**
	 * it will delete  a given person by id 	
	 */

	void deletePerson(Long id);

	/**
	 * 
	 * @return  returns the person with a given id
	 *  if person not found then it will throw runtime exception saying no such element found.
	 * 	 
	 */
	Person getPerson(Long id);

	/**
	 * it will insert list of person into the database in bulk mode.
	 * This is useful to insert many records quick and faster.
	 * @return  returns the resulted entities wrapped in Persons object. .
	 */
	Persons insertPersons(Persons persons);

}