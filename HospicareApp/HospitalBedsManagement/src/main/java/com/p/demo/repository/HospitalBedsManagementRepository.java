package com.p.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.p.demo.entity.HospitalBedsManagement;


public interface HospitalBedsManagementRepository extends JpaRepository<HospitalBedsManagement,Long>{
	
	List<HospitalBedsManagement> findByHospitalBedId(Long hospitalBedId);
	List<HospitalBedsManagement> findByMedicineId(Long medicineId);
	List<HospitalBedsManagement> findByNurseId(Long nurseId);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE HospitalBedsManagement SET nurseId=NULL WHERE hospitalBedId=?1 AND nurseId=?2")
	void deleteByHospitalBedNurseId(Long hospitalBedId,Long nurseId);
	
	@Transactional
	@Modifying
	@Query("UPDATE HospitalBedsManagement SET medicineId=NULL WHERE hospitalBedId=?1 AND medicineId=?2")
	void deleteByHospitalBedMedicineId(Long hospitalBedId,Long medicineId);

}
