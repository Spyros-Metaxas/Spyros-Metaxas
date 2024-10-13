package com.p.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p.demo.entity.Medicine;
import com.p.demo.repository.MedicineRepository;

@Service
public class MedicineService {
	
	@Autowired
	private MedicineRepository medicineRepository;

	public Medicine saveMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return medicineRepository.save(medicine);
	}

	@Transactional
	public Optional<Medicine> updateMedicine(Medicine medicine, Long id) {
		// TODO Auto-generated method stub
		medicineRepository.updateByMedicineId(id, medicine.getName(), medicine.getType(),medicine.getTherapeuticClassification(), medicine.getActiveIngredient(), medicine.getAvailability(), medicine.getExpiryDate());
		return medicineRepository.findById(id);
	}

	public String deleteMedicine(Long id) {
		if(medicineRepository.existsById(id)) {
			medicineRepository.deleteById(id);
			return "{\"status\":1}"; 
		}
		else {
			return "{\"status\":0}";
		}
	}

	public Optional<Medicine> findMedicineById(Long medicineId) {
		// TODO Auto-generated method stub
		return medicineRepository.findById(medicineId);
	}

}
