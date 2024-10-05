package com.p.demo.models;

import java.sql.Date;

public class Medicine {
	
private Long medicineId;
	
	private String name;
	private String type;
	private String therapeuticClassification;
	private String activeIngredient;
	private int availability;
	private Date expiryDate;
	
	public Long getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
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
	public String getTherapeuticClassification() {
		return therapeuticClassification;
	}
	public void setTherapeuticClassification(String therapeuticClassification) {
		this.therapeuticClassification = therapeuticClassification;
	}
	public String getActiveIngredient() {
		return activeIngredient;
	}
	public void setActiveIngredient(String activeIngredient) {
		this.activeIngredient = activeIngredient;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Medicine(Long medicineId, String name, String type, String therapeuticClassification,
			String activeIngredient, int availability, Date expiryDate) {
		super();
		this.medicineId = medicineId;
		this.name = name;
		this.type = type;
		this.therapeuticClassification = therapeuticClassification;
		this.activeIngredient = activeIngredient;
		this.availability = availability;
		this.expiryDate = expiryDate;
	}
	public Medicine(String name, String type, String therapeuticClassification, String activeIngredient,
			int availability, Date expiryDate) {
		super();
		this.name = name;
		this.type = type;
		this.therapeuticClassification = therapeuticClassification;
		this.activeIngredient = activeIngredient;
		this.availability = availability;
		this.expiryDate = expiryDate;
	}
	public Medicine() {
		super();
	}
	

}
