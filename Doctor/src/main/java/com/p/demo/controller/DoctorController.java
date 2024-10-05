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

import com.p.demo.entity.Doctor;
import com.p.demo.service.DoctorService;

@RestController
@RequestMapping(path = "doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping
	public Doctor saveDoctor(@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}
	
	@PutMapping(path="{doctorId}")
	public Optional<Doctor> updateDoctor(@RequestBody Doctor doctor,@PathVariable("doctorId") Long id) {
		return doctorService.updateDoctor(doctor,id);
	}
	
	@DeleteMapping(path="{doctorId}")
	public String deleteDoctor(@PathVariable("doctorId") Long id) {
		return doctorService.deleteDoctor(id);
	}
	
	@GetMapping(path="{Id}")
	public Optional<Doctor> findDoctorById(@PathVariable("Id") Long doctorId) {
		return doctorService.findDoctorById(doctorId);
	}
	
	@GetMapping(path="specialty/{specialtyid}")
	public List<Doctor> findDoctorBySpecialty(@PathVariable("specialtyid") String specialtyid){
		return doctorService.findDoctorBySpecialty(specialtyid);
	}
	
	@GetMapping(path="all")
	public List<Doctor> findAllDoctors(){
		return doctorService.findAllDoctors();
	}

}
