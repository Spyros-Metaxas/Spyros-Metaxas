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

import com.p.demo.entity.Measurement;
import com.p.demo.service.MeasurementService;

@RestController
@RequestMapping(path = "measurement")
public class MeasurementController {
	
	@Autowired
	private MeasurementService measurementService;
	
	@PostMapping
	public Measurement saveMeasurement(@RequestBody Measurement measurement) {
		return measurementService.saveMeasurement(measurement);
	}
	
	@PutMapping(path="{measurementId}")
	public Optional<Measurement> updateMeasurementById(@RequestBody Measurement measurement, @PathVariable("measurementId") Long measurementId) {
		return measurementService.updateMeasurementById(measurement, measurementId);
	}
	
	@DeleteMapping(path="{measurementId}")
	public String deleteMeasurementById(@PathVariable("measurementId") Long measurementId) {
		return measurementService.deleteMeasurementById(measurementId);
	}
	
	@GetMapping(path="{measurementId}")
	public Optional<Measurement> findMeasurementById(@PathVariable("measurementId") Long measurementId) {
		return measurementService.findMeasurementById(measurementId);
	}
	
	@GetMapping(path="all")
	public List<Measurement> findAllMeasurements(){
		return measurementService.findAllMeasurements();
	}
	
	@GetMapping(path="patient/{patientId}")
	public List<Measurement> findMeasurementsByPatientId(@PathVariable("patientId") Long patientId){
		return measurementService.findMeasurementsByPatientId(patientId);
	}
	
	@GetMapping(path="date/{date}")
	public List<Measurement> findMeasurementByDate(@PathVariable("date") String date){
		return measurementService.findMeasurementByDate(date);
	}
	
	@GetMapping(path="minimumdate/{date}")
	public List<Measurement> findMeasurementByMinimumDate(@PathVariable("date") String date){
		return measurementService.findMeasurementByMinimumDate(date);
	}
	
	@GetMapping(path="maximumdate/{date}")
	public List<Measurement> findMeasurementByMaximumDate(@PathVariable("date") String date){
		return measurementService.findMeasurementByMaximumDate(date);
	}

}
