package com.example.demo.pojo;

import com.example.demo.exception.PersonError;

public class PersonResponse {

	private Person person;
	private PersonError error;
	
	public PersonResponse() {}
	
	public PersonResponse(Person person, PersonError error) {
		super();
		this.person = person;
		this.error = error;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PersonError getError() {
		return error;
	}

	public void setError(PersonError error) {
		this.error = error;
	}
	
	
}
