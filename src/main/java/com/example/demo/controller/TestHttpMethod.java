package com.example.demo.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.component.PersonComponent;
import com.example.demo.exception.PersonError;
import com.example.demo.exception.SystemException;
import com.example.demo.pojo.Person;
import com.example.demo.pojo.PersonResponse;


@RestController
public class TestHttpMethod {
	
	private static final Log LOGGING = LogFactory.getLog(TestHttpMethod.class);
	
	@Autowired
	PersonComponent personComp;

	@GetMapping("/person/fn/{firstName}/ln/{lastName}")
	public ResponseEntity<PersonResponse> getCustomMessage(
			@RequestHeader(value="clientId", required=true) String clientId,
			@PathVariable(value="firstName") String fName,
			@PathVariable(value="lastName") String lName,
			@RequestParam Optional<String> age
			) {
		Person person = null;
		LOGGING.info("info logging");
		try {
			person = personComp.getPerson(fName, lName, age);
		} catch (SystemException e) {
			LOGGING.error("Logging for exception - server error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new PersonResponse(null, new PersonError(e.getErrId(), e.getMsg())));
			
		}
		
		if(!clientId.equalsIgnoreCase("test1")) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new PersonResponse(null, new PersonError("101", "header is wrong")));
		}
		if(person != null) {

			return ResponseEntity.status(HttpStatus.OK)
					.body(new PersonResponse(person, null));
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new PersonResponse(null, new PersonError("102", "Person is null")));
		}
	}
	
	@PostMapping(value="/addperson")
	public ResponseEntity<Person> createPerson(
			@RequestBody Person person
			){
		return ResponseEntity.ok().body(person);
	}
	
	@PutMapping(value="/modifyperson")
	public ResponseEntity<Person> modifyPerson(
			@RequestBody Person person
			){
		return ResponseEntity.ok().body(person);
	}
	
	@DeleteMapping(value="/delperson")
	public ResponseEntity<Person> deletePerson(
			@RequestBody Person person
			){
		return ResponseEntity.ok().body(person);
	}
}
