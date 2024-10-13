package com.p.demo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`prescription`")

public class Prescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long prescriptionId;
	
	private Long doctorId;
	private Long patientId;
	private Long medicineId;
	private Date startDate;
	private Date endDate;
	private String dosageForm;
	private int dosagePerDay;
	
	public Prescription(Long prescriptionId, Long doctorId, Long patientId, Long medicineId, Date startDate,
			Date endDate, String dosageForm, int dosagePerDay) {
		super();
		this.prescriptionId = prescriptionId;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.medicineId = medicineId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dosageForm = dosageForm;
		this.dosagePerDay = dosagePerDay;
	}

	public Prescription(Long doctorId, Long patientId, Long medicineId, Date startDate, Date endDate, String dosageForm,
			int dosagePerDay) {
		super();
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.medicineId = medicineId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dosageForm = dosageForm;
		this.dosagePerDay = dosagePerDay;
	}

	public Prescription() {
		super();
	}

	public Long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDosageForm() {
		return dosageForm;
	}

	public void setDosageForm(String dosageForm) {
		this.dosageForm = dosageForm;
	}

	public int getDosagePerDay() {
		return dosagePerDay;
	}

	public void setDosagePerDay(int dosagePerDay) {
		this.dosagePerDay = dosagePerDay;
	}
	
	
	

}
