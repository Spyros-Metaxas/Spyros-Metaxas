package com.p.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`measurement`")
public class Measurement {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long measurementId;
	
	private Long patientId;
	private String date;
	private String time;
	private String systolicBP;
	private String diastolicBP;
	private String heartrate;
	private String temperature;
	private String breathingRate;
	public Measurement(Long measurementId, Long patientId, String date, String time, String systolicBP,
			String diastolicBP, String heartrate, String temperature, String breathingRate) {
		super();
		this.measurementId = measurementId;
		this.patientId = patientId;
		this.date = date;
		this.time = time;
		this.systolicBP = systolicBP;
		this.diastolicBP = diastolicBP;
		this.heartrate = heartrate;
		this.temperature = temperature;
		this.breathingRate = breathingRate;
	}
	public Measurement(Long patientId, String date, String time, String systolicBP, String diastolicBP,
			String heartrate, String temperature, String breathingRate) {
		super();
		this.patientId = patientId;
		this.date = date;
		this.time = time;
		this.systolicBP = systolicBP;
		this.diastolicBP = diastolicBP;
		this.heartrate = heartrate;
		this.temperature = temperature;
		this.breathingRate = breathingRate;
	}
	public Measurement() {
		super();
	}
	public Long getMeasurementId() {
		return measurementId;
	}
	public void setMeasurementId(Long measurementId) {
		this.measurementId = measurementId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSystolicBP() {
		return systolicBP;
	}
	public void setSystolicBP(String systolicBP) {
		this.systolicBP = systolicBP;
	}
	public String getDiastolicBP() {
		return diastolicBP;
	}
	public void setDiastolicBP(String diastolicBP) {
		this.diastolicBP = diastolicBP;
	}
	public String getHeartrate() {
		return heartrate;
	}
	public void setHeartrate(String heartrate) {
		this.heartrate = heartrate;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getBreathingRate() {
		return breathingRate;
	}
	public void setBreathingRate(String breathingRate) {
		this.breathingRate = breathingRate;
	}
	
	

}
