package com.p.demo.controller;

import java.sql.Date;
import java.util.ArrayList;
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
import org.springframework.web.client.RestTemplate;

import com.p.demo.entity.Prescription;
import com.p.demo.models.Doctor;
import com.p.demo.models.Medicine;
import com.p.demo.models.Patient;
import com.p.demo.models.Response;
import com.p.demo.service.PrescriptionService;

@RestController
@RequestMapping(path="prescription")
public class PrescriptionController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public Prescription savePrescription(@RequestBody Prescription prescription) {
		return prescriptionService.savePrescription(prescription);
	}
	
	@GetMapping(path="{prescriptionId}")
	public Response findByPrescriptionId(@PathVariable("prescriptionId") Long prescriptionId){
		Response response =  new Response();
		Optional<Prescription> prescription = prescriptionService.findByPrescriptionId(prescriptionId);
		response.setDoctor(restTemplate.getForObject("http://DOCTOR-USS/doctor/"+prescription.get().getDoctorId(), Doctor.class));
		response.setPatient(restTemplate.getForObject("http://PATIENT-USS/patient/"+prescription.get().getPatientId(), Patient.class));
		response.setMedicine(restTemplate.getForObject("http://MEDICINE-USS/medicine/"+prescription.get().getMedicineId(), Medicine.class));
		response.setStartDate(prescription.get().getStartDate());
		response.setEndDate(prescription.get().getEndDate());
		response.setDosageForm(prescription.get().getDosageForm());
		response.setDosagePerDay(prescription.get().getDosagePerDay());
		return response;
	}
	@GetMapping(path="all")
	public List<Response> findAllApointments(){
		List<Response> responses = new ArrayList<Response>();
		List<Prescription> prescriptions = prescriptionService.findAllPrescriptions();
		prescriptions.stream().forEach((prescription) ->  responses.add(this.findByPrescriptionId(prescription.getPrescriptionId())));
		return responses;
	}
	
	
	@GetMapping(path="doctor/{doctorId}")
	public List<Response> findByDoctorId(@PathVariable("doctorId") Long doctorId){
		List<Response> responses = new ArrayList<Response>();
		Doctor doctor= restTemplate.getForObject("http://DOCTOR-USS/doctor/"+doctorId,Doctor.class);
		List<Prescription> prescriptions = prescriptionService.findByDoctorId(doctorId);
		prescriptions.stream().forEach((prescription) ->  responses.add(this.findByPrescriptionId(prescription.getPrescriptionId())));
		return responses;
	}
	
	@GetMapping(path="patient/{patientId}")
	public List<Response> findByPatientId(@PathVariable("patientId") Long patientId){
		List<Response> responses = new ArrayList<Response>();
		Patient patient= restTemplate.getForObject("http://PATIENT-USS/patient/"+patientId,Patient.class);
		List<Prescription> prescriptions = prescriptionService.findByPatientId(patientId);
		prescriptions.stream().forEach((prescription) ->  responses.add(this.findByPrescriptionId(prescription.getPrescriptionId())));
		return responses;
	}
	
	@GetMapping(path="medicine/{medicineId}")
	public List<Response> findByMedicineId(@PathVariable("medicineId") Long medicineId){
		List<Response> responses = new ArrayList<Response>();
		//Patient patient= restTemplate.getForObject("http://PATIENT-USS/patient/"+patientId,Patient.class);
		List<Prescription> prescriptions = prescriptionService.findByMedicineId(medicineId);
		prescriptions.stream().forEach((prescription) ->  responses.add(this.findByPrescriptionId(prescription.getPrescriptionId())));
		return responses;
	}
	
	@GetMapping(path="startDate/{startDate}")
	public List<Response> findByStartDate(@PathVariable("startDate") Date startDate){
		List<Response> responses = new ArrayList<Response>();
		List<Prescription> prescriptions = prescriptionService.findByStartDate(startDate);
		prescriptions.stream().forEach((prescription) ->  responses.add(this.findByPrescriptionId(prescription.getPrescriptionId())));
		return responses;
	}
	
	@GetMapping(path="endDate/{endDate}")
	public List<Response> findByEndDate(@PathVariable("endDate") Date endDate){
		List<Response> responses = new ArrayList<Response>();
		List<Prescription> prescriptions = prescriptionService.findByEndDate(endDate);
		prescriptions.stream().forEach((prescription) ->  responses.add(this.findByPrescriptionId(prescription.getPrescriptionId())));
		return responses;
	}
	
	@GetMapping(path="dosageForm/{dosageForm}")
	public List<Response> findByDosaseForm(@PathVariable("dosageForm") String dosageForm){
		List<Response> responses = new ArrayList<Response>();
		List<Prescription> prescriptions = prescriptionService.findByDosageForm(dosageForm);
		prescriptions.stream().forEach((prescription) ->  responses.add(this.findByPrescriptionId(prescription.getPrescriptionId())));
		return responses;
	}
	
	@GetMapping(path="dosagePerDay/{dosagePerDay}")
	public List<Response> findByDosasePerDay(@PathVariable("dosagePerDay") String dosagePerDay){
		List<Response> responses = new ArrayList<Response>();
		List<Prescription> prescriptions = prescriptionService.findByDosagePerDay(dosagePerDay);
		prescriptions.stream().forEach((prescription) ->  responses.add(this.findByPrescriptionId(prescription.getPrescriptionId())));
		return responses;
	}
	
	@DeleteMapping(path="{prescriptionId}")
	public String deletePrescriptionById(@PathVariable("prescriptionId") Long prescriptionId) {
		return prescriptionService.deletePrescriptionById(prescriptionId);
	}
	
	@PutMapping(path="{prescriptionId}")
	public Optional<Prescription> updatePrescription(@PathVariable("prescriptionId") Long prescriptionId,@RequestBody Prescription prescription){
		return prescriptionService.updatePrescription(prescriptionId, prescription);
	}

}
