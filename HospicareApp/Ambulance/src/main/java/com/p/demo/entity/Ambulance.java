package com.p.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`ambulance`")
public class Ambulance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ambulanceId;
	
	private String functionalType;
	private String vehicleType;
	private String brand;
	
	@Column(nullable = true)
	private String latitude;
	
	@Column(nullable = true)
	private String longitude;
	
	@Column(columnDefinition = "VARCHAR(60) CHECK (status IN ('FREE', 'OCCUPIED', 'SERVICE'))")
	private String status;
	
	@Column(nullable = true)
	private Long patientId;
	
	private Long employeeId; /*car driver */

	public Ambulance(Long ambulanceId, String functionalType, String vehicleType, String brand, String latitude,
			String longitude, String status, Long patientId, Long employeeId) {
		super();
		this.ambulanceId = ambulanceId;
		this.functionalType = functionalType;
		this.vehicleType = vehicleType;
		this.brand = brand;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
		this.patientId = patientId;
		this.employeeId = employeeId;
	}

	public Ambulance(String functionalType, String vehicleType, String brand, String latitude, String longitude,
			String status, Long patientId, Long employeeId) {
		super();
		this.functionalType = functionalType;
		this.vehicleType = vehicleType;
		this.brand = brand;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
		this.patientId = patientId;
		this.employeeId = employeeId;
	}

	public Ambulance() {
		super();
	}

	public Long getAmbulanceId() {
		return ambulanceId;
	}

	public void setAmbulanceId(Long ambulanceId) {
		this.ambulanceId = ambulanceId;
	}

	public String getFunctionalType() {
		return functionalType;
	}

	public void setFunctionalType(String functionalType) {
		this.functionalType = functionalType;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	

}
