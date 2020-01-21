package com.ebi.person.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebi.person.model.Person;
import com.ebi.person.model.Persons;
import com.ebi.person.service.PersonService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(PersonController.PATH)
public class PersonController {

	 public static final String PATH = "/persons";
	 
	 @Autowired
	 PersonService service;
	
	 @GetMapping
	  public ResponseEntity<Persons> getPersons( ) {		 
		 return ResponseEntity.ok().body(service.getAllPersons());
	 }
	 
	 
	 @GetMapping(value = "/{id}")	
	  public ResponseEntity<Person> getPerson(@PathVariable("id") final Long id) {		 
		 return ResponseEntity.ok().body(service.getPerson(id));
	 }
	 
	 
	 @PostMapping
	  public ResponseEntity<Person> addPerson(@RequestBody Person person) {		 
		 return ResponseEntity.ok().body(service.insertPerson(person));
	 }
	 
	 @PostMapping("/bulk")	
	  public ResponseEntity<Persons> addListOfPerson(@RequestBody Persons persons) {		 
		 return ResponseEntity.ok().body(service.insertPersons(persons));
	 }
	 
	 @PutMapping
	  public ResponseEntity<Person> updatePerson(@RequestBody Person person) {		 
		 return ResponseEntity.ok().body(service.updatePerson(person));
	 }
	 
	 
	 @DeleteMapping(value = "/{id}")	
	  public ResponseEntity removePerson(@PathVariable("id") final Long id) {	
		 service.deletePerson(id);
		 return ResponseEntity.ok().body(null);
	 }

}
