package com.p.demo.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`appointment`")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long appointmentId;
	
	private Long doctorId;
	private Long patientId;
	private Date date;
	private Time time;
	private String type;
	private Long nurseId;
	private Long vaccineId;
	private Long vaccineNum;
	
	public Appointment(Long appointmentId, Long doctorId, Long patientId, Date date, Time time, String type,
			Long nurseId, Long vaccineId) {
		super();
		this.appointmentId = appointmentId;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.date = date;
		this.time = time;
		this.type = type;
		this.nurseId = nurseId;
		this.vaccineId = vaccineId;
	}

	public Appointment() {
		super();
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
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

	public Long getNurseId() {
		return nurseId;
	}

	public void setNurseId(Long nurseId) {
		this.nurseId = nurseId;
	}

	public Long getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Long vaccineId) {
		this.vaccineId = vaccineId;
	}

	public Long getVaccineNum() {
		return vaccineNum;
	}

	public void setVaccineNum(Long vaccineNum) {
		this.vaccineNum = vaccineNum;
	}
	
	

}
