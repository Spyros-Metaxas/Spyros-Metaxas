package com.p.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.p.demo.entity.Nurse;

public interface NurseRepository extends JpaRepository<Nurse,Long> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Nurse SET firstName=?2, lastName=?3, specialty=?4 WHERE nurseId=?1")
	void updateNurseById(Long nurseId,String firstName, String lastName, String specialty);

}
