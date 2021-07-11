package com.example.demo.pojo;

public class Person {
	private String fName;
	private String lName;
	private Integer age;

	public Person() {}
	
	public Person(String fName, String lName, Integer age) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}
	
	public Person(String fName, String lName) {
		super();
		this.fName = fName;
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
