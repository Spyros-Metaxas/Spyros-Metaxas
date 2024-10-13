package com.p.demo.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.p.demo.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
	
	List<Appointment> findByDoctorId(Long doctorId);
	List<Appointment> findByPatientId(Long patientId);
	List<Appointment> findByType(String type);
	List<Appointment> findByDate(Date date);
	List<Appointment> findByNurseId(Long nurseId);
	List<Appointment> findByVaccineId(Long vaccineId);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Appointment SET doctorId=?2,patientId=?3,nurseId=?4,type=?5,date=?6,time=?7,vaccineId=?8 WHERE appointmentId=?1")
	void updateAppointment(Long appointmentId,Long doctorId,Long patientId,Long nurseId,String type,Date date,Time time,Long vaccineId);
	
}
