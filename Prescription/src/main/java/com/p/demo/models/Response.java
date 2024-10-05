package com.p.demo.models;

import java.sql.Date;

public class Response {
	
	private Doctor doctor;
	private Patient patient;
	private Medicine medicine;
	private Date startDate;
	private Date endDate;
	private String dosageForm;
	private int dosagePerDay;
	public Response(Doctor doctor, Patient patient, Medicine medicine, Date startDate, Date endDate, String dosageForm,
			int dosagePerDay) {
		super();
		this.doctor = doctor;
		this.patient = patient;
		this.medicine = medicine;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dosageForm = dosageForm;
		this.dosagePerDay = dosagePerDay;
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
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDosageForm() {
		return dosageForm;
	}
	public void setDosageForm(String dosageForm) {
		this.dosageForm = dosageForm;
	}
	public int getDosagePerDay() {
		return dosagePerDay;
	}
	public void setDosagePerDay(int dosagePerDay) {
		this.dosagePerDay = dosagePerDay;
	}
	
	
	
	
	

}
