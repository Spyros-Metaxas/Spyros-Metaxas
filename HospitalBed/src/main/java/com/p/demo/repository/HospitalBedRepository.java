package com.p.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.p.demo.entity.HospitalBed;


public interface HospitalBedRepository extends JpaRepository<HospitalBed,Long>{

	@Transactional
	@Modifying
	@Query("UPDATE HospitalBed SET statusfree=?2, patientId=?3,isICU=?4 WHERE hospitalbedId=?1")
	void updateByHospitalBedId(Long hospitalbedId,Boolean statusfree,Long patientId,boolean isICU);
	
	
	List<HospitalBed> findByStatusfree(boolean statusfree);
	Optional<HospitalBed> findByPatientId(Long patientId);
	List<HospitalBed> findByIsICU(boolean isICU);
	
}
