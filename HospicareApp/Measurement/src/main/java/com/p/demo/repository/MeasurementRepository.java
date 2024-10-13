package com.p.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.p.demo.entity.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement,Long>{

	@Transactional
	@Modifying
	@Query("UPDATE Measurement SET patientId=?2,date=?3,time=?4, systolicBP=?5, diastolicBP=?6, heartrate=?7, temperature=?8, breathingRate=?9 WHERE measurementId=?1")
	void updateMeasurementById(Long measurementId,Long patientId,String date,String time,String systolicBP,String diastolicBP, String heartrate,String temperature,String breathingRate);


	List<Measurement> findByPatientId(Long patientId);
	List<Measurement> findByDate(String date);
	
	@Query("SELECT t FROM Measurement t WHERE t.date>?1")
	List<Measurement> findMeasurementByMinimumDate(String date);
	
	@Query("SELECT t FROM Measurement t WHERE t.date<?1")
	List<Measurement> findMeasurementByMaximumDate(String date);
}
