package com.ebi.person.model;

import java.util.ArrayList;
import java.util.List;

public class Persons {
	
	List<Person> person= new ArrayList<>();

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

}
