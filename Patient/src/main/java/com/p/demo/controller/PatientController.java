package com.p.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p.demo.entity.Patient;
import com.p.demo.service.PatientService;

@RestController
@RequestMapping(path = "patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping
	public Patient savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}
	
	@PutMapping(path="{patientId}")
	public Optional<Patient> updatePatientById(@RequestBody Patient patient,@PathVariable("patientId") Long patientId){
		return patientService.updatePatientById(patient, patientId);
	}
	
	@PutMapping(path="hospitalpatient/{patientId}/{hospitalpatient}")
	public Optional<Patient> updateStatusOfPatient(@PathVariable("patientId") Long patientId,@PathVariable("hospitalpatient") boolean hospitalpatient){
		return patientService.updateStatusOfPatient(patientId, hospitalpatient);
	}
	
	@DeleteMapping(path="{patientId}")
	public String deletePatientById(@PathVariable("patientId") Long patientId) {
		return patientService.deletePatientById(patientId);
	}
	
	@GetMapping(path="{patientId}")
	public Optional<Patient> findPatientById(@PathVariable("patientId") Long patientId){
		return patientService.findPatientById(patientId);
	}
	
	@GetMapping(path="all")
	public List<Patient> findAllPatients(){
		return patientService.findAllPatients();
	}
	
	@GetMapping(path="hospitalpatient/{hospitalpatient}")
	public List<Patient> findByHospitalpatient(@PathVariable("hospitalpatient") boolean hospitalpatient){
		return patientService.findByHospitalpatient(hospitalpatient);
	}

}
