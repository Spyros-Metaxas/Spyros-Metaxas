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

import com.p.demo.entity.Ambulance;
import com.p.demo.models.Coordinates;
import com.p.demo.service.AmbulanceService;

@RestController
@RequestMapping(path = "ambulance")
public class AmbulanceController {
	
	@Autowired
	private AmbulanceService ambulanceService;
	
	
	@PostMapping
	public Ambulance saveAmbulance(@RequestBody Ambulance ambulance) {
		return ambulanceService.saveAmbulance(ambulance);
	}
	
	@PutMapping(path="{ambulanceId}")
	public Optional<Ambulance> updateAmbulanceById (@RequestBody Ambulance ambulance, @PathVariable("ambulanceId") Long ambulanceId){
		return ambulanceService.updateAmbulanceById(ambulance, ambulanceId);
	}
	
	@DeleteMapping(path="{ambulanceId}")
	public String deleteAmbulance(@PathVariable("ambulanceId") Long ambulanceId) {
		return ambulanceService.deleteAmbulance(ambulanceId);
	}
	
	@GetMapping(path="all")
	public List<Ambulance> findAllAmbulances(){
		return ambulanceService.findAllAmbulances();
	}
	
	@GetMapping(path="{ambulanceId}")
	public Optional<Ambulance> findAmbulanceById(@PathVariable("ambulanceId") Long ambulanceId) {
		return ambulanceService.findAmbulanceById(ambulanceId);
	}
	
	@GetMapping(path="coordinates/{ambulanceId}")
	public Coordinates getAmbulanceCoordinates(@PathVariable("ambulanceId") Long ambulanceId) {
		return ambulanceService.getAmbulanceCoordinates(ambulanceId);
	}
	
	@GetMapping(path="status/{statusid}")
	public List<Ambulance >findAmbulanceByStatus(@PathVariable("statusid") String statusid) {
		return ambulanceService.findAmbulanceByStatus(statusid);
	}
	
	@PutMapping(path="coordinates/{ambulanceId}")
	public Optional<Ambulance> updateAmbulanceCoordinates(@RequestBody Coordinates coordinates,@PathVariable("ambulanceId") Long ambulanceId) {
		return ambulanceService.updateAmbulanceCoordinates(coordinates, ambulanceId);
	}
	
	@PutMapping(path="updatePatient/{ambulanceId}/{patientId}")
	public Optional<Ambulance> updatePatientInAmbulance(@PathVariable("ambulanceId") Long ambulanceId,@PathVariable("patientId") Long patientId) {
		return ambulanceService.updatePatientInAmbulance(ambulanceId, patientId);
	}
	
	@PutMapping(path="updateStatus/{ambulanceId}/{status}")
	public Optional<Ambulance> updateStatusInAmbulance(@PathVariable("ambulanceId") Long ambulanceId,@PathVariable("status") String status){
		return ambulanceService.updateStatusInAmbulance(ambulanceId, status);
	}

}
