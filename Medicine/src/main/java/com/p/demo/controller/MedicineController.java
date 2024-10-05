package com.p.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p.demo.entity.Medicine;
import com.p.demo.service.MedicineService;


@RestController
@RequestMapping(path = "medicine")
public class MedicineController {
	
	@Autowired
	private MedicineService medicineService;

	@PostMapping
	public Medicine saveMedicine(@RequestBody Medicine medicine) {
		return medicineService.saveMedicine(medicine);
	}
	
	@PutMapping(path="{medicineId}")
	public Optional<Medicine> updateMedicine(@RequestBody Medicine medicine,@PathVariable("medicineId") Long id) {
		return medicineService.updateMedicine(medicine,id);
	}
	
	@DeleteMapping(path="{medicineId}")
	public String deleteMedicine(@PathVariable("medicineId") Long id) {
		return medicineService.deleteMedicine(id);
	}
	
	@GetMapping(path="{Id}")
	public Optional<Medicine> findMedicineById(@PathVariable("Id") Long medicineId) {
		return medicineService.findMedicineById(medicineId);
	}

}
