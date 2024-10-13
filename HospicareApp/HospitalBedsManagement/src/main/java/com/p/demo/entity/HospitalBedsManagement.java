package com.p.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`hospitalbedsmanagement`"/*,uniqueConstraints = {
	@UniqueConstraint(name = "UniqueBedAndNurse",columnNames = {"hospitalBedId","nurseId"}),
	@UniqueConstraint(name="UniqueBedAndMedicine",columnNames = {"hospitalBedId","medicineId"})
	
}*/)

public class HospitalBedsManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long hospitalBedManagementId;
	
	private Long hospitalBedId;
	
	@Column(nullable = true)
	private Long medicineId;
	
	@Column(nullable = true)
	private Long nurseId;
	
	
	public HospitalBedsManagement(Long hospitalBedManagementId, Long hospitalBedId, Long medicineId, Long nurseId) {
		super();
		this.hospitalBedManagementId = hospitalBedManagementId;
		this.hospitalBedId = hospitalBedId;
		this.medicineId = medicineId;
		this.nurseId = nurseId;
	}


	public HospitalBedsManagement(Long hospitalBedId, Long medicineId, Long nurseId) {
		super();
		this.hospitalBedId = hospitalBedId;
		this.medicineId = medicineId;
		this.nurseId = nurseId;
	}


	public HospitalBedsManagement() {
		super();
	}


	public Long getHospitalBedManagementId() {
		return hospitalBedManagementId;
	}


	public void setHospitalBedManagementId(Long hospitalBedManagementId) {
		this.hospitalBedManagementId = hospitalBedManagementId;
	}


	public Long getHospitalBedId() {
		return hospitalBedId;
	}


	public void setHospitalBedId(Long hospitalBedId) {
		this.hospitalBedId = hospitalBedId;
	}


	public Long getMedicineId() {
		return medicineId;
	}


	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}


	public Long getNurseId() {
		return nurseId;
	}


	public void setNurseId(Long nurseId) {
		this.nurseId = nurseId;
	}
	
	
	
	
	
	

}
