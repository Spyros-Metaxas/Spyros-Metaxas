package com.p.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.demo.entity.Vaccine;
import com.p.demo.repository.VaccineRepository;

@Service
public class VaccineService {
	
	@Autowired
	private VaccineRepository vaccineRepository;
	
	public Vaccine saveVaccine(Vaccine vaccine) {
		return vaccineRepository.save(vaccine);
	}
	
	public String deleteVaccine(Long vaccineId) {
		if(vaccineRepository.existsById(vaccineId)) {
			vaccineRepository.deleteById(vaccineId);
			return "{\"status\":1}";
		}
		else {
			return "{\"status\":0}";
		}
	}
	
	public Optional<Vaccine> findVaccineById(Long vaccineId) {
		return vaccineRepository.findById(vaccineId);
	}
    
	public List<Vaccine> findAllVaccines(){
		return vaccineRepository.findAll();
	}
	
	public List<Vaccine> findAllAvailableVaccine(){
		return vaccineRepository.findAllAvailableVaccines();
	}
	
	public Optional<Vaccine> updateVaccineAvailability(Long vaccineId,int availability) {
		vaccineRepository.updateVaccineAvailability(vaccineId, availability);
		return vaccineRepository.findById(vaccineId);
	}
	
	public Optional<Vaccine> updateVaccineById(Vaccine vaccine , Long vaccineId){
		vaccineRepository.updateVaccineById(vaccineId, vaccine.getName(), vaccine.getType(), vaccine.getBrand(), vaccine.getAvailability());
		return vaccineRepository.findById(vaccineId);
	}
	
	public List<Vaccine> findVaccineByBrand(String brand){
		return vaccineRepository.findByBrand(brand);
	}
	
	public List<Vaccine> findVaccineByType(String type){
		return vaccineRepository.findByType(type);
	}
}
