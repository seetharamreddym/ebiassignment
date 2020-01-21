package com.ebi.person.util;

import java.util.ArrayList;
import java.util.List;

import com.ebi.person.entity.HobbyEntity;
import com.ebi.person.entity.PersonEntity;
import com.ebi.person.model.Person;

public final class MarshallingUtil {

	private MarshallingUtil() {
	}

	public static Person convertToPersonPOJO(final PersonEntity personEntity) {
		Person result = new Person();
		result.setId(personEntity.getId());
		result.setFirst_name(personEntity.getFirstName());
		result.setLast_name(personEntity.getLastName());
		result.setAge(personEntity.getAge());
		result.setFavourite_color(personEntity.getFavouriteColor());
		result.setHobby(convertToHobbyList(personEntity.getHobbies()));

		return result;

	}

	public static List<String> convertToHobbyList(List<HobbyEntity> hobbyEntities) {

		List<String> hobbies = new ArrayList<>();
		hobbyEntities.forEach(hobby -> hobbies.add(hobby.getHobbyName()));
		return hobbies;

	}

	public static List<HobbyEntity> convertToHobbyEntities(List<String> hobbies) {

		List<HobbyEntity> hobbyEntities = new ArrayList<>();
		hobbies.forEach(hobby -> {
			HobbyEntity entity = new HobbyEntity();
			entity.setHobbyName(hobby);
			hobbyEntities.add(entity);
		});
		return hobbyEntities;

	}

	public static PersonEntity convertToPersonEntity(final Person person) {
		PersonEntity result = new PersonEntity();

		result.setId(person.getId());
		result.setFirstName(person.getFirst_name());
		result.setLastName(person.getLast_name());
		result.setAge(person.getAge());
		result.setFavouriteColor(person.getFavourite_color());
		result.setHobbies(convertToHobbyEntities(person.getHobby()));

		return result;

	}

	public static List<Person> getPersons(List<PersonEntity> allPersonEntities) {
		List<Person> result = new ArrayList<>();
		allPersonEntities.forEach(entity -> result.add(convertToPersonPOJO(entity)));
		return result;
	}

}
