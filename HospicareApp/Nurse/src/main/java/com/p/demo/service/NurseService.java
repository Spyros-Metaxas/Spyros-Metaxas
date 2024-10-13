package com.p.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.demo.entity.Nurse;
import com.p.demo.repository.NurseRepository;

@Service
public class NurseService {
	
	@Autowired
	private NurseRepository nurseRepository;
	
	
	public Nurse saveNurse(Nurse nurse) {
		return nurseRepository.save(nurse);
	}
	
	public Optional<Nurse> updateNurseById(Nurse nurse, Long nurseId){
		nurseRepository.updateNurseById(nurseId, nurse.getFirstName(), nurse.getLastName(), nurse.getSpecialty());
		return nurseRepository.findById(nurseId);
	}
	
	public String deleteNurseById(Long nurseId) {
		if(nurseRepository.existsById(nurseId)) {
			nurseRepository.deleteById(nurseId);
			return "{\"status\":1}";
		}
		else {
			return "{\"status\":0}";
		}
	}
	
	public Optional<Nurse> findNurseById(Long nurseId){
		return nurseRepository.findById(nurseId);
	}
	
	public List<Nurse> findAllNurses(){
		return nurseRepository.findAll();
	}
/*	
	public ResponseNurseHospitalBed addToHospitalBed(Long hospitalbedId,Long nurseId) {
		HospitalBed hospitalBed= restTemplate.getForObject("http://HOSPITALBED-USS/hospitalbed/"+ hospitalbedId.toString(), HospitalBed.class);
		hospitalBed.setNurseIdLong(nurseId);
		HttpEntity<HospitalBed> request= new HttpEntity<HospitalBed>(hospitalBed);
		ResponseEntity<HospitalBed> response= restTemplate.exchange("http://HOSPITALBED-USS/hospitalbed/nurse/"+hospitalbedId.toString(),HttpMethod.PUT, request, HospitalBed.class);
		ResponseNurseHospitalBed response2 = new ResponseNurseHospitalBed();
		response2.setHospitalBed(hospitalBed);
		response2.setNurse(nurseRepository.findById(nurseId));
		return response2;
	}

	public ResponseNurseHospitalBed removeFromHospitalBed(Long hospitalbedId,Long nurseId) {
		HospitalBed hospitalBed= restTemplate.getForObject("http://HOSPITALBED-USS/hospitalbed/"+ hospitalbedId.toString(), HospitalBed.class);
		hospitalBed.setNurseIdLong(null);
		HttpEntity<HospitalBed> request= new HttpEntity<HospitalBed>(hospitalBed);
		ResponseEntity<HospitalBed> response= restTemplate.exchange("http://HOSPITALBED-USS/hospitalbed/nurse/"+hospitalbedId.toString(),HttpMethod.PUT, request, HospitalBed.class);
		ResponseNurseHospitalBed response2 = new ResponseNurseHospitalBed();
		response2.setHospitalBed(hospitalBed);
		response2.setNurse(nurseRepository.findById(nurseId));
		return response2;
	}
	*/
}
