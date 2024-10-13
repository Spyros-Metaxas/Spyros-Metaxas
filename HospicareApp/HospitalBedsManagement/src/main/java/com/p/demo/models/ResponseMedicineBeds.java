package com.p.demo.models;

import java.util.List;

public class ResponseMedicineBeds {
	
	private Medicine medicine;
	private List<HospitalBed> hospitalbeds;
	public ResponseMedicineBeds(Medicine medicine, List<HospitalBed> hospitalbeds) {
		super();
		this.medicine = medicine;
		this.hospitalbeds = hospitalbeds;
	}
	public ResponseMedicineBeds() {
		super();
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public List<HospitalBed> getHospitalbeds() {
		return hospitalbeds;
	}
	public void setHospitalbeds(List<HospitalBed> hospitalbeds) {
		this.hospitalbeds = hospitalbeds;
	}
	
	

}
