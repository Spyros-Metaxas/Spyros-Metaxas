package com.p.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.demo.entity.Schedule;
import com.p.demo.repository.ScheduleRepository;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public Schedule saveSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}
	
	public String deleteScheduleById(Long scheduleId) {
		if(scheduleRepository.existsById(scheduleId)) {
			scheduleRepository.deleteById(scheduleId);
			return "{\"status\":1}";
		}
		else {
			return "{\"status\":0}";
		}
	}
	
	public Optional<Schedule> updateScheduleById(Long scheduleId,Schedule schedule){
		scheduleRepository.updateScheduleById(scheduleId, schedule.getType(), schedule.getStartDate(), schedule.getEndDate(), schedule.getStartTime(), schedule.getEndTime(), schedule.getEmployeeId());
		return scheduleRepository.findById(scheduleId);
	}
	
	public Optional<Schedule> findByScheduleId(Long scheduleId){
		return scheduleRepository.findById(scheduleId);
	}
	
	public List<Schedule> findAllSchedules(){
		return scheduleRepository.findAll();
	}
	
	public List<Schedule> findByType(String type){
		return scheduleRepository.findByType(type);
	}
	
	public List<Schedule> findByEmployeeId(Long employeeId){
		return scheduleRepository.findByEmployeeId(employeeId);
	}
	
	public List<Schedule> findByStartDate(Date startDate){
		return scheduleRepository.findByStartDate(startDate);
	}
	
	public List<Schedule> findByEndDate(Date endDate){
		return scheduleRepository.findByEndDate(endDate);
	}
	
	public List<Schedule> findByMaximumStartDate(Date startDate){
		return scheduleRepository.findByMaximumStartDate(startDate);
	}
	
	public List<Schedule> findByMinimumStartDate(Date startDate){
		return scheduleRepository.findByMinimumStartDate(startDate);
	}
	
	public List<Schedule> findByMaximumEndDate(Date endDate){
		return scheduleRepository.findByMaximumEndDate(endDate);
	}
	
	public List<Schedule> findByMinimumEndDate(Date endDate){
		return scheduleRepository.findByMinimumEndDate(endDate);
	}

}
