package com.p.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.demo.entity.Prescription;
import com.p.demo.repository.PrescriptionRepository;

@Service
public class PrescriptionService {

	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	public Prescription savePrescription(Prescription prescription) {
		return prescriptionRepository.save(prescription);
	}
	
	public String deletePrescriptionById(Long prescriptionId) {
		if(prescriptionRepository.existsById(prescriptionId)) {
			prescriptionRepository.deleteById(prescriptionId);
			return "{\"status\":1}";
		}
		else {
			return "{\"status\":0}";
		}
	}
	
	public Optional<Prescription> updatePrescription(Long prescriptionId,Prescription prescription){
		prescriptionRepository.updatePrescription(prescriptionId, prescription.getDoctorId(), prescription.getPatientId(), prescription.getMedicineId(), prescription.getDosageForm(), prescription.getDosagePerDay());
		return prescriptionRepository.findById(prescriptionId);
	}
	
	public Optional<Prescription> findByPrescriptionId(Long prescriptionId){
		return prescriptionRepository.findById(prescriptionId);
	}
	
	public List<Prescription> findAllPrescriptions(){
		return prescriptionRepository.findAll();
	}
	
	public List<Prescription> findByDoctorId(Long doctorId){
		return prescriptionRepository.findByDoctorId(doctorId);
	}
	
	
	public List<Prescription> findByPatientId(Long patientId){
		return prescriptionRepository.findByPatientId(patientId);
	}
	
	public List<Prescription> findByMedicineId(Long medicineId){
		return prescriptionRepository.findByMedicineId(medicineId);
	}
	
	public List<Prescription> findByStartDate(Date startDate){
		return prescriptionRepository.findByStartDate(startDate);
	}
	
	public List<Prescription> findByEndDate(Date endDate){
		return prescriptionRepository.findByEndDate(endDate);
	}
	
	public List<Prescription> findByDosageForm(String dosageForm){
		return prescriptionRepository.findByDosageForm(dosageForm);
	}
	
	public List<Prescription> findByDosagePerDay(String dosagePerDay){
		return prescriptionRepository.findByDosagePerDay(dosagePerDay);
	}
}
