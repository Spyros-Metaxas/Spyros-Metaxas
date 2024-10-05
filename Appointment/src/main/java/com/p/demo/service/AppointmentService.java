package com.p.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.demo.entity.Appointment;
import com.p.demo.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	public String deleteAppointmentById(Long appointmentId) {
		if(appointmentRepository.existsById(appointmentId)) {
			appointmentRepository.deleteById(appointmentId);
			return "{\"status\":1}";
		}
		else {
			return "{\"status\":0}";
		}
	}
	
	public Optional<Appointment> updateByAppointment(Long appointmentId, Appointment appointment){
		appointmentRepository.updateAppointment(appointmentId, appointment.getDoctorId(), appointment.getPatientId(), appointment.getNurseId(), appointment.getType(), appointment.getDate(), appointment.getTime(),appointment.getVaccineId());
		return appointmentRepository.findById(appointmentId);
	}
	
	public Optional<Appointment> findByAppointmentId(Long appointmentId){
		return appointmentRepository.findById(appointmentId);
	}
	
	public List<Appointment> findAllAppointments(){
		return appointmentRepository.findAll();
	}
	
	public List<Appointment> findByDoctorId(Long doctorId){
		return appointmentRepository.findByDoctorId(doctorId);
	}
	
	public List<Appointment> findByPatientId(Long patientId){
		return appointmentRepository.findByPatientId(patientId);
	}
	
	public List<Appointment> findByType(String type){
		return appointmentRepository.findByType(type);
	}
	
	public List<Appointment> findByDate(Date date){
		return appointmentRepository.findByDate(date);
	}
	
	public List<Appointment> findByNurseId(Long nurseId){
		return appointmentRepository.findByNurseId(nurseId);
	}
	
	public List<Appointment> findByVaccineId(Long vaccineId){
		return appointmentRepository.findByVaccineId(vaccineId);
	}
}
