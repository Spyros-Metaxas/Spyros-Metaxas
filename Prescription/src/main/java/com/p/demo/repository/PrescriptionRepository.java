package com.p.demo.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.p.demo.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long>{
	
	List<Prescription> findByDoctorId(Long doctorId);
	List<Prescription> findByPatientId(Long patientId);
	List<Prescription> findByMedicineId(Long medicineId);
	List<Prescription> findByStartDate(Date startDate);
	List<Prescription> findByEndDate(Date endDate);
	List<Prescription> findByDosageForm(String dosageForm);
	List<Prescription> findByDosagePerDay(String dosagePerDay);
	
	@Transactional
	@Modifying
	@Query("UPDATE Prescription SET doctorId=?2,patientId=?3,medicineId=?4,dosageForm=?5,dosagePerDay=?6 WHERE prescriptionId=?1")
	void updatePrescription(Long prescriptionId,Long doctorId,Long patientId,Long medicineId,String dosageForm,int dosagePerDay);
}
