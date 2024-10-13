package com.p.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.p.demo.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Doctor SET firstName=?2, lastName=?3, specialty=?4 WHERE doctorId=?1")
	void updateByDoctorId(Long doctorId,String firstname,String lastname, String specialty);
	
	List<Doctor> findBySpecialty(String specialty);
	
	

}
