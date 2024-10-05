package com.p.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.p.demo.entity.HospitalBedsManagement;
import com.p.demo.models.HospitalBed;
import com.p.demo.models.Medicine;
import com.p.demo.models.Nurse;
import com.p.demo.models.ResponseHospitalBeds;
import com.p.demo.models.ResponseMedicineBeds;
import com.p.demo.models.ResponseNurseBeds;
import com.p.demo.service.HospitalBedsManagementService;

@RestController
@RequestMapping(path="hospitalbedsmanagement")
public class HospitalBedsManagementController {
	
	
	@Autowired
	private HospitalBedsManagementService hospitalBedsManagementService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public HospitalBedsManagement saveHospitalBedsManagement(@RequestBody HospitalBedsManagement hospitalBedsManagement) {
		return hospitalBedsManagementService.saveHospitalBedsManagement(hospitalBedsManagement);
	}
	
	@GetMapping(path="nurse/{nurseId}")
	public ResponseNurseBeds findHospitalBedsByNurseId(@PathVariable("nurseId") Long nurseId) {
		ResponseNurseBeds response= new ResponseNurseBeds();
		Nurse nurse= restTemplate.getForObject("http://NURSE-USS/nurse/"+nurseId, Nurse.class);
		List<HospitalBedsManagement> list= hospitalBedsManagementService.findByNurseId(nurseId);
		List<HospitalBed> listofBeds = new ArrayList<HospitalBed>();
		list.stream().forEach((hospitalbedsmanagement) -> listofBeds.add(restTemplate.getForObject("http://HOSPITALBED-USS/hospitalbed/"+hospitalbedsmanagement.getHospitalBedId(), HospitalBed.class)));
		response.setNurse(nurse);
		response.setHospitalBeds(listofBeds);
		return response;
	}
	
	@GetMapping(path="medicine/{medicineId}")
	public ResponseMedicineBeds findHospitalBedsByMedicineId(@PathVariable("medicineId") Long medicineId) {
		ResponseMedicineBeds response = new ResponseMedicineBeds();
		Medicine medicine = restTemplate.getForObject("http://MEDICINE-USS/medicine/"+medicineId, Medicine.class);
		List<HospitalBedsManagement> list= hospitalBedsManagementService.findByMedicineId(medicineId);
		List<HospitalBed> listofBeds = new ArrayList<HospitalBed>();
		list.stream().forEach((hospitalbedsmanagement) -> listofBeds.add(restTemplate.getForObject("http://HOSPITALBED-USS/hospitalbed/"+hospitalbedsmanagement.getHospitalBedId(), HospitalBed.class)));
		response.setMedicine(medicine);
		response.setHospitalbeds(listofBeds);
		return response;
		
	}
	
	@GetMapping(path="hospitalbed/{hospitalbedid}")
	public ResponseHospitalBeds findHospitalBedsInfo(@PathVariable("hospitalbedid") Long hospitalbedid) {
		ResponseHospitalBeds response = new ResponseHospitalBeds();
		HospitalBed hospitalBed= restTemplate.getForObject("http://HOSPITALBED-USS/hospitalbed/"+hospitalbedid, HospitalBed.class);
		List<HospitalBedsManagement> list= hospitalBedsManagementService.findByHospitalBedId(hospitalbedid);
		List<Nurse> listOfNurses= new ArrayList<Nurse>();
		List<Medicine> listOfMedicines= new ArrayList<Medicine>();
		list.stream().forEach((hospitalbedsmanagement) ->{
			if(hospitalbedsmanagement.getNurseId()!=null) {listOfNurses.add(restTemplate.getForObject("http://NURSE-USS/nurse/"+hospitalbedsmanagement.getNurseId(), Nurse.class));}});
		list.stream().forEach((hospitalbedsmanagement) ->{
			if(hospitalbedsmanagement.getMedicineId()!=null) {listOfMedicines.add(restTemplate.getForObject("http://MEDICINE-USS/medicine/"+hospitalbedsmanagement.getMedicineId(), Medicine.class));}});

		response.setHospitalBed(hospitalBed);
		response.setNurses(listOfNurses);
		response.setMedicines(listOfMedicines);
		return response;
	}
	
	@PutMapping(path="deletenursehospitalbed/{hospitalbedid}/{nurseId}")
	public List<HospitalBedsManagement> deleteNurseFromHospitalBed(@PathVariable("hospitalbedid") Long hospitalbedid,@PathVariable("nurseId") Long nurseId){
		return hospitalBedsManagementService.deleteNurseFromHospitalBed(hospitalbedid, nurseId);
	}
	
	@PutMapping(path="deletemedicinehospitalbed/{hospitalbedid}/{medicineId}")
	public List<HospitalBedsManagement> deleteMedicineFromHospitalBed(@PathVariable("hospitalbedid") Long hospitalbedid,@PathVariable("medicineId") Long medicineId){
		return hospitalBedsManagementService.deleteMedicineFromHospitalBed(hospitalbedid, medicineId);
	}
}
