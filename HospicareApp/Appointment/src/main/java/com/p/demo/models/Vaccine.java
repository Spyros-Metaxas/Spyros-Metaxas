package com.p.demo.models;

public class Vaccine {
	

	private Long vaccineId;
	private String name;
	private String type;
	private String brand;
	private int availability;
	
	public Vaccine(Long vaccineId, String name, String type, String brand, int availability) {
		super();
		this.vaccineId = vaccineId;
		this.name = name;
		this.type = type;
		this.brand = brand;
		this.availability = availability;
	}

	public Vaccine(String name, String type, String brand, int availability) {
		super();
		this.name = name;
		this.type = type;
		this.brand = brand;
		this.availability = availability;
	}

	public Vaccine() {
		super();
	}

	public Long getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Long vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	
	
}
