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

import com.p.demo.entity.Appointment;
import com.p.demo.models.Doctor;
import com.p.demo.models.Nurse;
import com.p.demo.models.Patient;
import com.p.demo.models.Response;
import com.p.demo.models.Vaccine;
import com.p.demo.service.AppointmentService;

@RestController
@RequestMapping(path="appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public Appointment saveAppointment(@RequestBody Appointment appointment) {
		return appointmentService.saveAppointment(appointment);
	}
	
	@GetMapping(path="{appointmentId}")
	public Response findByAppointmentId(@PathVariable("appointmentId") Long appointmentId){
		Response response =new Response();
		Optional<Appointment> appointment =  appointmentService.findByAppointmentId(appointmentId);
		response.setDoctor(restTemplate.getForObject("http://DOCTOR-USS/doctor/"+appointment.get().getDoctorId(), Doctor.class));
		response.setPatient(restTemplate.getForObject("http://PATIENT-USS/patient/"+appointment.get().getPatientId(), Patient.class));
		if(appointment.get().getNurseId()!=null) {response.setNurse(restTemplate.getForObject("http://NURSE-USS/nurse/"+appointment.get().getNurseId(), Nurse.class));}
		else {response.setNurse(null);}
		if(appointment.get().getVaccineId()!=null) {response.setVaccine(restTemplate.getForObject("http://VACCINE-USS/vaccine/"+appointment.get().getVaccineId(), Vaccine.class));}
		else {response.setVaccine(null);}
		response.setDate(appointment.get().getDate());
		response.setTime(appointment.get().getTime());
		response.setType(appointment.get().getType());
		response.setVaccineNum(appointment.get().getVaccineNum());
	
		return response;
	}
	
	@DeleteMapping(path="{appointmentId}")
	public String deleteAppointmentById(@PathVariable("appointmentId") Long appointmentId) {
		return appointmentService.deleteAppointmentById(appointmentId);
	}
	
	@PutMapping(path="{appointmentId}")
	public Optional<Appointment> updateByAppointment(@PathVariable("appointmentId") Long appointmentId,@RequestBody Appointment appointment){
		return appointmentService.updateByAppointment(appointmentId, appointment);
	}
	
	
	@GetMapping(path="all")
	public List<Response> findAllAppointments(){
		List<Response> responses = new ArrayList<Response>();
		List<Appointment> appointments = appointmentService.findAllAppointments();
		appointments.stream().forEach((appointment) -> responses.add(this.findByAppointmentId(appointment.getAppointmentId())));
		return responses;
	}
	
	@GetMapping(path="doctor/{doctorId}")
	public List<Response> findByDoctorId(@PathVariable("doctorId") Long doctorId){
		List<Response> responses = new ArrayList<Response>();
		List<Appointment> appointments = appointmentService.findByDoctorId(doctorId);
		appointments.stream().forEach((appointment) -> responses.add(this.findByAppointmentId(appointment.getAppointmentId())));
		return responses;
	}
	
	@GetMapping(path="patient/{patientId}")
	public List<Response> findByPatientId(@PathVariable("patientId") Long patientId){
		List<Response> responses = new ArrayList<Response>();
		List<Appointment> appointments = appointmentService.findByPatientId(patientId);
		appointments.stream().forEach((appointment) -> responses.add(this.findByAppointmentId(appointment.getAppointmentId())));
		return responses;
	}
	
	@GetMapping(path="type/{type}")
	public List<Response> findByType(@PathVariable("type") String type){
		List<Response> responses = new ArrayList<Response>();
		List<Appointment> appointments = appointmentService.findByType(type);
		appointments.stream().forEach((appointment) -> responses.add(this.findByAppointmentId(appointment.getAppointmentId())));
		return responses;
	}
	
	@GetMapping(path="date/{date}")
	public List<Response> findByDate(@PathVariable("date") Date date){
		List<Response> responses = new ArrayList<Response>();
		List<Appointment> appointments = appointmentService.findByDate(date);
		appointments.stream().forEach((appointment) -> responses.add(this.findByAppointmentId(appointment.getAppointmentId())));
		return responses;
	}
	
	@GetMapping(path="nurse/{nurseId}")
	public List<Response> findByNurseId(@PathVariable("nurseId") Long nurseId){
		List<Response> responses = new ArrayList<Response>();
		List<Appointment> appointments = appointmentService.findByNurseId(nurseId);
		appointments.stream().forEach((appointment) -> responses.add(this.findByAppointmentId(appointment.getAppointmentId())));
		return responses;
	}
	
	@GetMapping(path="vaccine/{vaccineId}")
	public List<Response> findByVaccineId(@PathVariable("vaccineId") Long vaccineId){
		List<Response> responses = new ArrayList<Response>();
		List<Appointment> appointments = appointmentService.findByVaccineId(vaccineId);
		appointments.stream().forEach((appointment) -> responses.add(this.findByAppointmentId(appointment.getAppointmentId())));
		return responses;
	}
}
