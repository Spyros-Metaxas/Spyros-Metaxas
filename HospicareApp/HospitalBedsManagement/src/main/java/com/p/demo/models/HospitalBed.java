package com.p.demo.models;

public class HospitalBed {
	

	private Long hospitalbedId;
	private int number;
	private String roomnumber;
	private int floor;
	private String ward;
	private boolean statusfree;
	private Long patientId;
	private boolean isICU;

	
	public HospitalBed(int number, String roomnumber, int floor, String ward, boolean statusfree, Long patientId,
			boolean isICU) {
		super();
		this.number = number;
		this.roomnumber = roomnumber;
		this.floor = floor;
		this.ward = ward;
		this.statusfree = statusfree;
		this.patientId = patientId;
		this.isICU = isICU;
		
	}

	public HospitalBed(Long hospitalbedId, int number, String roomnumber, int floor, String ward, boolean statusfree,
			Long patientId, boolean isICU) {
		super();
		this.hospitalbedId = hospitalbedId;
		this.number = number;
		this.roomnumber = roomnumber;
		this.floor = floor;
		this.ward = ward;
		this.statusfree = statusfree;
		this.patientId = patientId;
		this.isICU = isICU;
		
	}

	public HospitalBed() {
		super();
	}

	public Long getHospitalbedId() {
		return hospitalbedId;
	}

	public void setHospitalbedId(Long hospitalbedId) {
		this.hospitalbedId = hospitalbedId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public boolean isStatusfree() {
		return statusfree;
	}

	public void setStatusfree(boolean statusfree) {
		this.statusfree = statusfree;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}


	public boolean isICU() {
		return isICU;
	}

	public void setICU(boolean isICU) {
		this.isICU = isICU;
	}
	

}
