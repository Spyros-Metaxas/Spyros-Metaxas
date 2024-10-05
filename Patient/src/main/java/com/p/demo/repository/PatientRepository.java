package com.p.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.p.demo.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long>{
	
	List<Patient> findByHospitalpatient(boolean hospitalpatient);
	List<Patient> findBySex(String sex);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Patient SET firstName=?2,midName=?3,lastName=?4,mobilePhone=?5,address=?6,sex=?7,birthDate=?8,hospitalpatient=?9 WHERE patientId=?1")
	void updatePatientById(Long patientId,String firstName,String midName,String lastName,Long mobilePhone,String address,String sex,Date birthDate,boolean hospitalpatient);

	
	@Transactional
	@Modifying
	@Query("UPDATE Patient SET hospitalpatient=?2 WHERE patientId=?1")
	void updateStatusOfPatient(Long patientId,boolean hospitalpatient);
}
