package com.openwebinars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table; 

@Entity
@NamedQuery(name = "Student.findById", query = "select s from Student s where s.id = ?1")
@Table(name = "STUDENT")
public class Student {

	public Student() {}
	
	public Student(long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//sirve para obligar a que el campo id sea autoincremental
	@Column(name="studentId")
	private long id;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
