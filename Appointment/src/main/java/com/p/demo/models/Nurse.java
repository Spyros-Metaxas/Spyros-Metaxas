package com.p.demo.models;

public class Nurse {
	

	private Long nurseId;
	private String firstName;
	private String lastName;
	private String specialty;
	private Long employeeId;

	public Nurse(Long nurseId, String firstName, String lastName, String specialty, Long employeeId) {
		super();
		this.nurseId = nurseId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.employeeId = employeeId;
	}

	public Nurse(String firstName, String lastName, String specialty, Long employeeId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.employeeId = employeeId;
	}

	public Nurse() {
		super();
	}

	public Long getNurseId() {
		return nurseId;
	}

	public void setNurseId(Long nurseId) {
		this.nurseId = nurseId;
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

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	
	

}
