package com.p.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.demo.entity.Measurement;
import com.p.demo.repository.MeasurementRepository;

@Service
public class MeasurementService {
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	public Measurement saveMeasurement(Measurement measurement) {
		return measurementRepository.save(measurement);
	}
	
	public String deleteMeasurementById(Long measurementId) {
		if(measurementRepository.existsById(measurementId)) {
			measurementRepository.deleteById(measurementId);
			return "{\"status\":1}";
		}
		else {
			return "{\"status\":0}";
		}
	}
	
	public Optional<Measurement> updateMeasurementById(Measurement measurement, Long measurementId){
		measurementRepository.updateMeasurementById(measurementId, measurement.getPatientId(), measurement.getDate(), measurement.getTime(), measurement.getSystolicBP(), measurement.getDiastolicBP(), measurement.getHeartrate(), measurement.getTemperature(),measurement.getBreathingRate());
		return measurementRepository.findById(measurementId);
	}
	
	public Optional<Measurement> findMeasurementById(Long measurementId){
		return measurementRepository.findById(measurementId);
	}
	
	public List<Measurement> findAllMeasurements(){
		return measurementRepository.findAll();
	}
	
	public List<Measurement> findMeasurementsByPatientId(Long patientId){
		return measurementRepository.findByPatientId(patientId);
	}
	
	public List<Measurement> findMeasurementByDate(String date){
		return measurementRepository.findByDate(date);
	}
	
	public List<Measurement> findMeasurementByMinimumDate(String date){
		return measurementRepository.findMeasurementByMinimumDate(date);
	}
	
	public List<Measurement> findMeasurementByMaximumDate(String date){
		return measurementRepository.findMeasurementByMaximumDate(date);
	}

}
