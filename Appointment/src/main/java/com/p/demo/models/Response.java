package com.p.demo.models;

import java.sql.Date;
import java.sql.Time;

public class Response {
	
	private Doctor doctor;
	private Patient patient;
	private Nurse nurse;
	private Vaccine vaccine;
	private Long vaccineNum;
	private Date date;
	private Time time;
	private String type;
	
	

	public Response(Doctor doctor, Patient patient, Nurse nurse, Vaccine vaccine, Long vaccineNum, Date date, Time time,
			String type) {
		super();
		this.doctor = doctor;
		this.patient = patient;
		this.nurse = nurse;
		this.vaccine = vaccine;
		this.vaccineNum = vaccineNum;
		this.date = date;
		this.time = time;
		this.type = type;
	}

	public Response() {
		super();
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getVaccineNum() {
		return vaccineNum;
	}

	public void setVaccineNum(Long vaccineNum) {
		this.vaccineNum = vaccineNum;
	}
	
	

}
