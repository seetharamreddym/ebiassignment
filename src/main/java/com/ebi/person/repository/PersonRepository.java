package com.ebi.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebi.person.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}
