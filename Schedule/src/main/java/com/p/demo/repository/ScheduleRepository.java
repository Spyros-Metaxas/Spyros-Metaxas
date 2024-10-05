package com.p.demo.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.p.demo.entity.Schedule;


public interface ScheduleRepository extends JpaRepository<Schedule,Long>{
	
	List<Schedule> findByType(String type);
	List<Schedule> findByEmployeeId(Long employeeId);
	List<Schedule> findByStartDate(Date startDate);
	List<Schedule> findByEndDate(Date endDate);
	
	@Query("SELECT t FROM Schedule t WHERE t.startDate<?1")
	List<Schedule> findByMaximumStartDate(Date startDate);
	
	@Query("SELECT t FROM Schedule t WHERE t.startDate>?1")
	List<Schedule> findByMinimumStartDate(Date startDate);
	
	@Query("SELECT t FROM Schedule t WHERE t.endDate<?1")
	List<Schedule> findByMaximumEndDate(Date endDate);
	
	@Query("SELECT t FROM Schedule t WHERE t.endDate>?1")
	List<Schedule> findByMinimumEndDate(Date endDate);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Schedule SET type=?2,startDate=?3, endDate=?4, startTime=?5, endTime=?6,employeeId=?7 WHERE scheduleId=?1")
	void updateScheduleById(Long scheduleId,String type,Date startDate,Date endDate,Time startTime,Time endTime,Long employeeId);
}
