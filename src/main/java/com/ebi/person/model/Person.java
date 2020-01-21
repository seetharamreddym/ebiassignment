package com.ebi.person.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
private Long id;
private String first_name;
private String last_name;
private Integer age;
private String favourite_color;
private List<String> hobby= new ArrayList<>();

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getFavourite_color() {
	return favourite_color;
}
public void setFavourite_color(String favourite_color) {
	this.favourite_color = favourite_color;
}
public List<String> getHobby() {
	return hobby;
}
public void setHobby(List<String> hobby) {
	this.hobby = hobby;
}

}
