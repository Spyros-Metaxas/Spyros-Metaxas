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

import com.p.demo.entity.HospitalBed;
import com.p.demo.service.HospitalBedService;

@RestController
@RequestMapping(path = "hospitalbed")
public class HospitalBedController {
	
	@Autowired
	private HospitalBedService hospitalbedService;

	@PostMapping
	public HospitalBed saveHospitalBed(@RequestBody HospitalBed hospitalbed) {
		return hospitalbedService.saveHospitalBed(hospitalbed);
	}
	
	@PutMapping(path="{hospitalbedId}")
	public Optional<HospitalBed> updateHospitalBed(@RequestBody HospitalBed hospitalbed,@PathVariable("hospitalbedId") Long id) {
		return hospitalbedService.updateHospitalBed(hospitalbed,id);
	}
	
	
	@DeleteMapping(path="{hospitalbedId}")
	public String deleteHospitalBed(@PathVariable("hospitalbedId") Long id) {
		return hospitalbedService.deleteHospitalBed(id);
	}
	
	@GetMapping(path="{Id}")
	public Optional<HospitalBed> findHospitalBedById(@PathVariable("Id") Long hospitalbedId) {
		return hospitalbedService.findHospitalBedById(hospitalbedId);
	}
	
	@GetMapping(path="free")
	public List<HospitalBed> findFreeHospitalBeds(){
		return hospitalbedService.findFreeHospitalBeds();
	}
	
	@GetMapping(path="notfree")
	public List<HospitalBed> findNotFreeHospitalBeds(){
		return hospitalbedService.findNotFreeHospitalBeds();
	}
	
	@GetMapping(path="all")
	public List<HospitalBed> findAllHospitalBeds(){
		return hospitalbedService.findAllHospitalBeds();
	}
	
	
	@GetMapping(path="patient/{patientId}")
	public Optional<HospitalBed> findBedByPatient(@PathVariable("patientId") Long patientId){
		return hospitalbedService.findHospitalBedByPatient(patientId);
	}
	
	@GetMapping(path="ICU/{isICU}")
	public List<HospitalBed> findTypeOfHospitalBeds(@PathVariable("isICU") boolean isICU){
		return hospitalbedService.findByIsICU(isICU);
	}

}
