package com.p.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.p.demo.entity.Vaccine;


public interface VaccineRepository extends JpaRepository<Vaccine,Long> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Vaccine SET name=?2, type=?3, brand=?4, availability=?5 WHERE vaccineId=?1")
	void updateVaccineById(Long vaccineId, String name,String type,String brand,int availability);
	
	List<Vaccine> findByBrand(String brand);
	
	List<Vaccine> findByType(String type);
	
	@Transactional
	@Modifying
	@Query("UPDATE Vaccine SET availability=?2 WHERE vaccineId=?1")
	void updateVaccineAvailability(Long vaccineId, int availability);
	
	
	@Query("SELECT t FROM Vaccine t WHERE t.availability>0")
	List<Vaccine> findAllAvailableVaccines();

}
