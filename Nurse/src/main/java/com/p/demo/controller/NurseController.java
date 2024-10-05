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

import com.p.demo.entity.Nurse;
import com.p.demo.service.NurseService;

@RestController
@RequestMapping(path = "nurse")
public class NurseController {
	
	@Autowired
	private NurseService nurseService;
	
	@PostMapping
	public Nurse saveNurse(@RequestBody Nurse nurse) {
		return nurseService.saveNurse(nurse);
	}
	
	@PutMapping(path="{nurseId}")
	public Optional<Nurse> updateNurseById(@RequestBody Nurse nurse, @PathVariable("nurseId") Long nurseId){
		return nurseService.updateNurseById(nurse, nurseId);
	}
	
	@DeleteMapping(path="{nurseId}")
	public String deleteNurse(@PathVariable("nurseId") Long nurseId) {
		return nurseService.deleteNurseById(nurseId);
	}
	
	@GetMapping(path="{nurseId}")
	public Optional<Nurse> findNurseById(@PathVariable("nurseId") Long nurseId){
		return nurseService.findNurseById(nurseId);
	}
	
	@GetMapping(path="all")
	public List<Nurse> findAllNurses(){
		return nurseService.findAllNurses();
	}
	
/*	@PutMapping(path="addToBed/{hospitalbedId}/{nurseId}")
	public  ResponseNurseHospitalBed addNurseToBed(@PathVariable("hospitalbedId") Long hospitalbedId, @PathVariable("nurseId") Long nurseId) {
		return nurseService.addToHospitalBed(hospitalbedId, nurseId);
	}
	
	@PutMapping(path="removeFromBed/{hospitalbedId}/{nurseId}")
	public @ResponseBody ResponseNurseHospitalBed removeFromBed(@PathVariable("hospitalbedId") Long hospitalbedId, @PathVariable("nurseId") Long nurseId) {
		return nurseService.removeFromHospitalBed(hospitalbedId, nurseId);
	}
*/	
	//@GetMapping(path="getBeds/{nurseId}")
	

}
