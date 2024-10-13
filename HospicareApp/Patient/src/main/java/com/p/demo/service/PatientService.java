package com.p.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.demo.entity.Patient;
import com.p.demo.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	public Optional<Patient> updatePatientById(Patient patient,Long patientId){
		patientRepository.updatePatientById(patientId, patient.getFirstName(), patient.getMidName(), patient.getLastName(), patient.getMobilePhone(), patient.getAddress(), patient.getSex(), patient.getBirthDate(), patient.isHospitalpatient());
		return patientRepository.findById(patientId);
	}
	
	public Optional<Patient> updateStatusOfPatient(Long patientId, boolean hospitalpatient){
		patientRepository.updateStatusOfPatient(patientId, hospitalpatient);
		return patientRepository.findById(patientId);
	}
	
	public String deletePatientById(Long patientId) {
		if(patientRepository.existsById(patientId)) {
			patientRepository.deleteById(patientId);
			return "{\"status\":1}";
		}
		else {
			return "{\"status\":0}";
		}
	}
	
	public Optional<Patient> findPatientById(Long patientId){
		return patientRepository.findById(patientId);
	}
	
	public List<Patient> findAllPatients(){
		return patientRepository.findAll();
	}
	
	public List<Patient> findByHospitalpatient(boolean hospitalpatient){
		return patientRepository.findByHospitalpatient(hospitalpatient);
	}

}
