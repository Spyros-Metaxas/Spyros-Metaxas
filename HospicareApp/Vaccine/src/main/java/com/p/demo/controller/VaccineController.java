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

import com.p.demo.entity.Vaccine;
import com.p.demo.service.VaccineService;

@RestController
@RequestMapping(path="vaccine")
public class VaccineController {
	
	@Autowired
	private VaccineService vaccineService;
	
	@PutMapping(path="{vaccineId}")
	public Optional<Vaccine> updateVaccine(@RequestBody Vaccine vaccine, @PathVariable("vaccineId") Long vaccineId){
		return vaccineService.updateVaccineById(vaccine, vaccineId);
	}
	
	@PostMapping
	public Vaccine saveVaccine(@RequestBody Vaccine vaccine) {
		return vaccineService.saveVaccine(vaccine);
	}
	
	@DeleteMapping(path="{vaccineId}")
	public String deleteVaccine(@PathVariable("vaccineId") Long vaccineId) {
		return vaccineService.deleteVaccine(vaccineId);
	}
	
	@GetMapping(path="{vaccineId}")
	public Optional<Vaccine> findVaccineById(@PathVariable("vaccineId") Long vaccineId) {
		return vaccineService.findVaccineById(vaccineId);
	}
	
	@GetMapping(path="all")
	public List<Vaccine> findAllVaccines(){
		return vaccineService.findAllVaccines();
	}
	
	@GetMapping(path="allavailable")
	public List<Vaccine> findAllAvailableVaccines(){
		return vaccineService.findAllAvailableVaccine();
	}
	
	@GetMapping(path="brand/{brandid}")
	public List<Vaccine> findVaccineByBrand(@PathVariable("brandid") String brandid){
		return vaccineService.findVaccineByBrand(brandid);
	}
	
	@GetMapping(path="type/{typeid}")
	public List<Vaccine> findVaccineByType(@PathVariable("typeid") String typeid){
		return vaccineService.findVaccineByType(typeid);
	}
	
	@PutMapping(path="availability/{vaccineId}/{availability}")
	public Optional<Vaccine> updateVaccineAvailability(@PathVariable("vaccineId") Long vaccineId, @PathVariable("availability") int availability){
		return vaccineService.updateVaccineAvailability(vaccineId, availability);
	}
}
