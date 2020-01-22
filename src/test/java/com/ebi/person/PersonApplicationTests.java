package com.ebi.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebi.person.exception.ApplicationException;
import com.ebi.person.model.Person;
import com.ebi.person.model.Persons;
import com.ebi.person.service.PersonService;



/**
 * @author seetharam
 * 
 * This  class tests all operations on person service.
 */
@SpringBootTest
class PersonApplicationTests {

	@Autowired
	private PersonService service;

	@Test
	public void testAddAndUpdatePerson() {

		// insert
		Person per1 = new Person();
		per1.setAge(36);
		per1.setFirst_name("ram");
		per1.getHobby().add("dance");
		Person insertedPerson1 = service.insertPerson(per1);
		assertNotNull(insertedPerson1.getId());
		assertNull(insertedPerson1.getLast_name());
		assertEquals(1, insertedPerson1.getHobby().size());
	
		// update
		insertedPerson1.setLast_name("kumar");
		insertedPerson1.getHobby().add("music");
		Person updatedPerson1 = service.updatePerson(insertedPerson1);
		assertEquals(insertedPerson1.getId(), updatedPerson1.getId());
		assertNotNull(updatedPerson1.getLast_name());
		assertEquals(2, updatedPerson1.getHobby().size());
}
	
	@Test
	public void testGetAllPersons() {
		Person per2 = new Person();
		per2.setAge(36);
		per2.setFirst_name("shylesh");
		per2.getHobby().add("cricket");
		service.insertPerson(per2);
		Person per3 = new Person();
		per3.setAge(30);
		per3.setFirst_name("mahesh");
		per3.getHobby().add("music");
		service.insertPerson(per3);

		// get all
		Persons allPersons = service.getAllPersons();
		assertEquals(3, allPersons.getPerson().size());
		
		
}
	
	@Test
	public void testDeletePerson() {
		Person per7 = new Person();
		per7.setAge(30);
		per7.setFirst_name("john");
		per7.getHobby().add("music");
		
		Person insertPerson = service.insertPerson(per7);
		service.deletePerson(insertPerson.getId());
		
		 Assertions.assertThrows(ApplicationException.class, () -> {
			 service.getPerson(insertPerson.getId());;
			  });
	

	}
		@Test
		public void testBulkInsertPersons() {
		// bulk insert

		Person per4 = new Person();
		per4.setAge(36);
		per4.setFirst_name("ram");
		per4.getHobby().add("dance");
		Person per5 = new Person();
		per5.setAge(36);
		per5.setFirst_name("shylesh");
		per5.getHobby().add("cricket");

		Person per6 = new Person();
		per6.setAge(30);
		per6.setFirst_name("mahesh");
		per6.getHobby().add("music");

		Persons all = new Persons();
		all.getPerson().add(per4);
		all.getPerson().add(per5);
		all.getPerson().add(per6);
		service.insertPersons(all);

		// after bulk insert validate total
		Persons allPersons = service.getAllPersons();
		assertEquals(6, allPersons.getPerson().size());

	}

}
