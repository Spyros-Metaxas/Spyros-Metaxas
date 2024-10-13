package com.p.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.demo.entity.Ambulance;
import com.p.demo.models.Coordinates;
import com.p.demo.repository.AmbulanceRepository;

@Service
public class AmbulanceService {
	
	@Autowired
	private AmbulanceRepository ambulanceRepository;
	
	public Ambulance saveAmbulance(Ambulance ambulance) {
		return ambulanceRepository.save(ambulance);
	}
	
	public Optional<Ambulance> updateAmbulanceById(Ambulance ambulance, Long ambulanceId){
		ambulanceRepository.updateAmbulanceById(ambulanceId, ambulance.getFunctionalType(), ambulance.getVehicleType(), ambulance.getBrand(), ambulance.getEmployeeId());
		return ambulanceRepository.findById(ambulanceId);
	}
	
	public Optional<Ambulance> updateStatusInAmbulance(Long ambulanceId,String status) {
		ambulanceRepository.updateStatusInAmbulance(ambulanceId, status);
		return ambulanceRepository.findById(ambulanceId);
	}
	
	public String deleteAmbulance(Long ambulanceId) {
		if(ambulanceRepository.existsById(ambulanceId)) {
			ambulanceRepository.deleteById(ambulanceId);
			return "{\"status\":1}";
		}
		else {
			return "{\"status\":0}";
		}
	}
	
	public List<Ambulance> findAllAmbulances(){
		return ambulanceRepository.findAll();
	}
	
	public Optional<Ambulance> findAmbulanceById(Long ambulanceId) {
		return ambulanceRepository.findById(ambulanceId);
	}
	
	public Coordinates getAmbulanceCoordinates(Long ambulanceId) {
		Coordinates coordinates = new Coordinates();
		Optional<Ambulance> ambulance= ambulanceRepository.findById(ambulanceId);
		coordinates.setLatitude(ambulance.get().getLatitude());
		coordinates.setLongtitude(ambulance.get().getLongitude());
		return coordinates;
	}
	
	public Optional<Ambulance> updateAmbulanceCoordinates(Coordinates coordinates, Long ambulanceId) {
		ambulanceRepository.updateCoordinatesInAmbulance(ambulanceId, coordinates.getLatitude(), coordinates.getLongtitude());
		return ambulanceRepository.findById(ambulanceId);
	}
	
	public List<Ambulance> findAmbulanceByStatus(String status){
		return ambulanceRepository.findByStatus(status);
	}
	
	public Optional<Ambulance> updatePatientInAmbulance(Long ambulanceId,Long patientId) {
		ambulanceRepository.updatePatientInAmbulance(ambulanceId, patientId);
		return ambulanceRepository.findById(ambulanceId);
	}

}
