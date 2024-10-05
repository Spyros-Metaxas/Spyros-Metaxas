package com.p.demo.entity;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`patient`")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patientId;
	
	private String firstName;
	private String midName;
	private String lastName;
	private Long mobilePhone;
	private String address;
	private String sex;
	private Date birthDate;
	private boolean hospitalpatient;
	public Patient(Long patientId, String firstName, String midName, String lastName, Long mobilePhone, String address,
			String sex, Date birthDate, boolean hospitalpatient) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.mobilePhone = mobilePhone;
		this.address = address;
		this.sex = sex;
		this.birthDate = birthDate;
		this.hospitalpatient = hospitalpatient;
	}
	public Patient(String firstName, String midName, String lastName, Long mobilePhone, String address, String sex,
			Date birthDate, boolean hospitalpatient) {
		super();
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.mobilePhone = mobilePhone;
		this.address = address;
		this.sex = sex;
		this.birthDate = birthDate;
		this.hospitalpatient = hospitalpatient;
	}
	public Patient() {
		super();
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMidName() {
		return midName;
	}
	public void setMidName(String midName) {
		this.midName = midName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(Long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public boolean isHospitalpatient() {
		return hospitalpatient;
	}
	public void setHospitalpatient(boolean hospitalpatient) {
		this.hospitalpatient = hospitalpatient;
	}
	
	

}
