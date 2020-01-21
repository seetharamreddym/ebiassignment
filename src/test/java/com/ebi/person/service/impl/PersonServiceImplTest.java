package com.ebi.person.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ebi.person.entity.HobbyEntity;
import com.ebi.person.entity.PersonEntity;
import com.ebi.person.model.Person;
import com.ebi.person.repository.PersonRepository;
import com.ebi.person.service.PersonService;
import static com.ebi.person.util.MarshallingUtil.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonServiceImplTest {
	
	@Mock
    private PersonRepository personRepository;

    @InjectMocks // auto inject helloRepository
    private PersonService personService = new PersonServiceImpl();

    @Test
    public void testGetAllPerson() {
    	
    	List<PersonEntity>  result= new ArrayList<>();  	
    	 PersonEntity pers1 = new PersonEntity();
    	 PersonEntity pers2 = new PersonEntity();   	 
    	 pers1.setAge(36);
    	 pers1.setFirstName("ram");
     	List<HobbyEntity>  hobbyList1= new ArrayList<>();  
    	 HobbyEntity hobby1 = new HobbyEntity();
    	 hobby1.setHobbyName("music");
    	 pers1.setHobbies(hobbyList1);
		pers1.getHobbies().add(hobby1);
    	 pers2.setAge(38);
    	 pers2.setFirstName("jagan");
    	 List<HobbyEntity>  hobbyList2= new ArrayList<>();  
    	 HobbyEntity hobby2 = new HobbyEntity();
    	 hobby2.setHobbyName("dance");
    	 pers2.setHobbies(hobbyList2);
		pers2.getHobbies().add(hobby2);
    	 result.add(pers1);
    	 result.add(pers2);   	 
    	  
    	
    	when(personRepository.findAll()).thenReturn(result);
    	
    	assertEquals(2, personService.getAllPersons().getPerson().size());
    	
    }
    
    
//    @Test
//    public void testinsertPerson() {
//    	
//    	 PersonEntity persEntity1 = new PersonEntity();  
//    	 persEntity1.setId(1l);
//    	 persEntity1.setAge(36);
//    	 persEntity1.setFirstName("ram");
//    	 List<HobbyEntity>  hobbyList= new ArrayList<>();  
//    	 HobbyEntity hobby = new HobbyEntity();
//    	 hobby.setHobbyName("dance");
//    	 persEntity1.setHobbies(hobbyList);
//    	
//    	 
//    	 PersonEntity persEntityResult1 = new PersonEntity();
//    	 persEntityResult1.setId(1l);
//    	 persEntityResult1.setAge(36);
//    	 persEntityResult1.setFirstName("ram");
//    	 List<HobbyEntity>  hobbyList1= new ArrayList<>();  
//    	 HobbyEntity hobby1 = new HobbyEntity();
//    	 hobby1.setHobbyName("dance");
//    	 persEntityResult1.setHobbies(hobbyList1);
//    	 persEntityResult1.getHobbies().add(hobby1);
//    
//    	 Person per1 = new Person();
//    	 per1.setAge(36);
//    	 per1.setFirst_name("ram");
//    	 per1.getHobby().add("dance");
//    
//    	 
//    	 
//    	when(personRepository.save(convertToPersonEntity(per1))).thenReturn(persEntityResult1);
//    	
//    	assertEquals(1, personService.insertPerson(per1).getId());
//    	
//    }
    
}
