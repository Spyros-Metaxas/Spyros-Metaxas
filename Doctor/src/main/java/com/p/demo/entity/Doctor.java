package com.p.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`doctor`")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long doctorId;
	
	private String firstName;
	private String lastName;
	private String specialty;
	private Long employeeId;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long userId) {
		this.doctorId = userId;
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
	public Doctor(Long doctorId, String firstName, String lastName, String specialty, Long employeeId) {
		super();
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.employeeId = employeeId;
	}
	public Doctor(String firstName, String lastName, String specialty, Long employeeId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.employeeId = employeeId;
	}
	public Doctor() {
		super();
	}
	
	

}
