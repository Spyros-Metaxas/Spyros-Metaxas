package com.p.demo.models;

import java.util.List;

public class ResponseHospitalBeds {
	
	private HospitalBed hospitalBed;
	private List<Nurse> nurses;
	private List<Medicine> medicines;
	public ResponseHospitalBeds(HospitalBed hospitalBed, List<Nurse> nurses, List<Medicine> medicines) {
		super();
		this.hospitalBed = hospitalBed;
		this.nurses = nurses;
		this.medicines = medicines;
	}
	public ResponseHospitalBeds() {
		super();
	}
	public HospitalBed getHospitalBed() {
		return hospitalBed;
	}
	public void setHospitalBed(HospitalBed hospitalBed) {
		this.hospitalBed = hospitalBed;
	}
	public List<Nurse> getNurses() {
		return nurses;
	}
	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}
	public List<Medicine> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	
	

}
