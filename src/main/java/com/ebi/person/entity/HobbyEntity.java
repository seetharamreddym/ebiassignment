package com.ebi.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HobbyEntity {
	
	@Id
    @GeneratedValue
    private Long id;
	

    @Column(name = "HOBBY")
	private String hobbyName;
	

    @Column(name = "PERSON_ID")
	private Long personId;

	public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
