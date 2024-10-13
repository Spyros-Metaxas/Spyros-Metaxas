package com.p.demo.models;

import java.util.Optional;

import com.p.demo.entity.Nurse;

public class ResponseNurseHospitalBed {
	
	private HospitalBed hospitalBed;
	private Optional<Nurse> nurse;
	public ResponseNurseHospitalBed(HospitalBed hospitalBed, Nurse nurse) {
		super();
		this.hospitalBed = hospitalBed;
		this.nurse = Optional.ofNullable(nurse);
	}
	public ResponseNurseHospitalBed() {
		super();
	}
	public HospitalBed getHospitalBed() {
		return hospitalBed;
	}
	public void setHospitalBed(HospitalBed hospitalBed) {
		this.hospitalBed = hospitalBed;
	}
	public Optional<Nurse> getNurse() {
		return nurse;
	}
	public void setNurse(Optional<Nurse> nurse) {
		this.nurse = nurse;
	}
	
	

}
