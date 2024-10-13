package com.p.demo.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.p.demo.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Medicine SET name=?2, type=?3, therapeuticClassification=?4,activeIngredient=?5,availability=?6,expiryDate=?7 WHERE medicineId=?1")
	void updateByMedicineId(Long medicineId,String name,String type,String therapeuticClassification,String activeIngredient,int i,Date date);

}
