package com.p.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.demo.entity.HospitalBedsManagement;
import com.p.demo.repository.HospitalBedsManagementRepository;

@Service
public class HospitalBedsManagementService {
	
	@Autowired
	private HospitalBedsManagementRepository hospitalBedsManagementRepository;
	
	public HospitalBedsManagement saveHospitalBedsManagement(HospitalBedsManagement hospitalBedsManagement) {
		return hospitalBedsManagementRepository.save(hospitalBedsManagement);
	}
	
	public String deleteHospitalBedsManagementById(Long hospitalBedsManagementId) {
		if(hospitalBedsManagementRepository.existsById(hospitalBedsManagementId)) {
			hospitalBedsManagementRepository.deleteById(hospitalBedsManagementId);
			return "{\"status\":1}";
		}
		else {
			return "{\"status\":0}";
		}
		

}
	
	public Optional<HospitalBedsManagement> findByHospitalBedsManagementId(Long hospitalBedsManagementId){
		return hospitalBedsManagementRepository.findById(hospitalBedsManagementId);
	}
	
	public List<HospitalBedsManagement> findByNurseId(Long nurseId){
		return hospitalBedsManagementRepository.findByNurseId(nurseId);
	}
	
	public List<HospitalBedsManagement> findByMedicineId(Long medicineId){
		return hospitalBedsManagementRepository.findByMedicineId(medicineId);
	}
	
	public List<HospitalBedsManagement> findByHospitalBedId(Long hospitalBedId){
		return hospitalBedsManagementRepository.findByHospitalBedId(hospitalBedId);
	}
	
	public List<HospitalBedsManagement> deleteNurseFromHospitalBed(Long hospitalBedId,Long nurseId){
		hospitalBedsManagementRepository.deleteByHospitalBedNurseId(hospitalBedId, nurseId);
		return hospitalBedsManagementRepository.findByHospitalBedId(hospitalBedId);
		
	}
	
	public List<HospitalBedsManagement> deleteMedicineFromHospitalBed(Long hospitalBedId,Long medicineId){
		hospitalBedsManagementRepository.deleteByHospitalBedMedicineId(hospitalBedId, medicineId);
		return hospitalBedsManagementRepository.findByHospitalBedId(hospitalBedId);
		
	}
	
	
	
	
}
