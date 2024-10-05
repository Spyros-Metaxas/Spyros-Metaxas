package com.p.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.demo.entity.HospitalBed;
import com.p.demo.repository.HospitalBedRepository;

@Service
public class HospitalBedService {
	
	@Autowired
	private HospitalBedRepository hospitalBedRepository;

	public HospitalBed saveHospitalBed(HospitalBed hospitalbed) {
		// TODO Auto-generated method stub
		return hospitalBedRepository.save(hospitalbed);
	}

	public Optional<HospitalBed> updateHospitalBed(HospitalBed hospitalbed, Long id) {
		// TODO Auto-generated method stub
		hospitalBedRepository.updateByHospitalBedId(id, hospitalbed.isStatusfree(), hospitalbed.getPatientId(),hospitalbed.isICU());
		return hospitalBedRepository.findById(id);
	}

	public String deleteHospitalBed(Long id) {
		// TODO Auto-generated method stub
		if(hospitalBedRepository.existsById(id)) {
			hospitalBedRepository.deleteById(id);
			return "{\"status\":1}";
		}
		else {
			return "{\"status\":0}";
		}
		
	}

	public Optional<HospitalBed> findHospitalBedById(Long hospitalbedId) {
		// TODO Auto-generated method stub
		return hospitalBedRepository.findById(hospitalbedId);
	}
 

	public List<HospitalBed> findFreeHospitalBeds() {
		// TODO Auto-generated method stub
		return hospitalBedRepository.findByStatusfree(true);
		
	} 
	
	public List<HospitalBed> findNotFreeHospitalBeds() {
		// TODO Auto-generated method stub
		return hospitalBedRepository.findByStatusfree(false);
	} 
	
	public List<HospitalBed> findAllHospitalBeds(){
		return hospitalBedRepository.findAll();
	}


	public Optional<HospitalBed> findHospitalBedByPatient(Long patientId) {
		// TODO Auto-generated method stub
		return hospitalBedRepository.findByPatientId(patientId);
	}
	
	public List<HospitalBed> findByIsICU(boolean isICU){
		return hospitalBedRepository.findByIsICU(isICU);
	}
	
}
