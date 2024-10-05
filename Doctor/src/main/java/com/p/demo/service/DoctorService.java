package com.p.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p.demo.entity.Doctor;
import com.p.demo.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public String deleteDoctor(Long id) {
		if(doctorRepository.existsById(id)) {
			doctorRepository.deleteById(id);
			return "{\"status\":1}"; 
		}
		else {
			return "{\"status\":0}";
		}
	}

	@Transactional
	public Optional<Doctor> updateDoctor(Doctor doctor, Long doctorId) {
		doctorRepository.updateByDoctorId(doctorId,doctor.getFirstName(),doctor.getLastName(),doctor.getSpecialty());
		return doctorRepository.findById(doctorId);
		
	}

	public Optional<Doctor> findDoctorById(Long doctorId) {
		return doctorRepository.findById(doctorId);
	}
	
	public List<Doctor> findDoctorBySpecialty(String specialty){
		return doctorRepository.findBySpecialty(specialty);
	}
	
	public List<Doctor> findAllDoctors(){
		return doctorRepository.findAll();
	}

}
