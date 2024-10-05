package com.p.demo.models;

import java.util.List;

public class ResponseNurseBeds {
	
	private Nurse nurse;
	private List<HospitalBed> hospitalBeds;
	public ResponseNurseBeds(Nurse nurse, List<HospitalBed> hospitalBeds) {
		super();
		this.nurse = nurse;
		this.hospitalBeds = hospitalBeds;
	}
	public ResponseNurseBeds() {
		super();
	}
	public Nurse getNurse() {
		return nurse;
	}
	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}
	public List<HospitalBed> getHospitalBeds() {
		return hospitalBeds;
	}
	public void setHospitalBeds(List<HospitalBed> hospitalBeds) {
		this.hospitalBeds = hospitalBeds;
	}
	
	

}
