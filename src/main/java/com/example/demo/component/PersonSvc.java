package com.example.demo.component;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.SystemException;
import com.example.demo.pojo.Person;

@Service
public class PersonSvc {

	public Person getSvc(String fName, String lName, 
			Integer age) {
		if(age !=null) {
			return new Person(fName, lName, age);
		}
		return new Person(fName, lName);
	}
	
	public Integer getAge(Optional<String> age) throws SystemException {
		if(age.isPresent()) {
			try {
				return Integer.parseInt(age.get());
			} catch (Exception e) {
				throw new SystemException("103", "age is not integer wirh exception msg: "+e.getMessage());
			}
		}
		return null;	
	}
}
