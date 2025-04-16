package com.ahv.emsp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="first_Name")
	private String firstName;
	
	@Column(name ="last_Name")
	private String lasttName;
	
	@Column(name ="email_id", nullable=false, unique=true)
	private String email;
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasttName() {
		return lasttName;
	}
	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//Constructor
	public Employee(Long id, String firstName, String lasttName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lasttName = lasttName;
		this.email = email;
	}
	
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lasttName=" + lasttName + ", email=" + email
				+ "]";
	}	
}
