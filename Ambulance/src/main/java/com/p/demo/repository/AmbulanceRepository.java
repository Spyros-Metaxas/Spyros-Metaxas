package com.p.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.p.demo.entity.Ambulance;

public interface AmbulanceRepository extends JpaRepository<Ambulance,Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Ambulance SET functionalType=?2, vehicleType=?3, brand=?4,employeeId=?5 WHERE ambulanceId=?1")
	void updateAmbulanceById(Long ambulanceId,String functionalType, String vehicleType,String brand,Long employeeId);

	@Transactional
	@Modifying
	@Query("UPDATE Ambulance SET patientId=?2 WHERE ambulanceId=?1")
	void updatePatientInAmbulance(Long ambulanceId,Long patientId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Ambulance SET status=?2 WHERE ambulanceId=?1")
	void updateStatusInAmbulance(Long ambulanceId,String status);
	
	List<Ambulance> findByStatus(String status);
	
	@Transactional
	@Modifying
	@Query("UPDATE Ambulance SET latitude=?2,longitude=?3  WHERE ambulanceId=?1")
	void updateCoordinatesInAmbulance(Long ambulanceId, String latitude, String longitude);
	
}
