package com.p.demo.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.client.RestTemplate;

import com.p.demo.entity.Schedule;
import com.p.demo.models.Employee;
import com.p.demo.models.Response;
import com.p.demo.service.ScheduleService;

@RestController
@RequestMapping(path="schedule")
public class ScheduleController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@PostMapping
	public Schedule saveSchedule(@RequestBody Schedule schedule) {
		return scheduleService.saveSchedule(schedule);
	}
	
	@DeleteMapping(path="{scheduleId}")
	public String deleteScheduleById(@PathVariable("scheduleId") Long scheduleId) {
		return scheduleService.deleteScheduleById(scheduleId);
	}
	
	@PutMapping(path="{scheduleId}")
	public Optional<Schedule> updateScheduleById(@PathVariable("scheduleId") Long scheduleId,@RequestBody Schedule schedule){
		return scheduleService.updateScheduleById(scheduleId, schedule);
	}
	
	@GetMapping(path="{scheduleId}")
	public Response findByScheduleId(@PathVariable("scheduleId") Long scheduleId){
		Response response =new Response();
		Optional<Schedule> schedule = scheduleService.findByScheduleId(scheduleId);
		response.setEmployee(restTemplate.getForObject("http://EMPLOYEE-USS/employee/"+ schedule.get().getEmployeeId(), Employee.class));
		response.setStartDate(schedule.get().getStartDate());
		response.setEndDate(schedule.get().getEndDate());
		response.setStartTime(schedule.get().getStartTime());
		response.setEndTime(schedule.get().getEndTime());
		response.setType(schedule.get().getType());
		return response;
	}
	
	@GetMapping(path="all")
	public List<Response> findAllSchedules(){
		List<Response> responses = new ArrayList<Response>();
		List<Schedule> schedules = scheduleService.findAllSchedules();
		schedules.stream().forEach((schedule) -> responses.add(this.findByScheduleId(schedule.getScheduleId())));
		return responses;
	}
	
	@GetMapping(path="type/{type}")
	public List<Response> findByType(@PathVariable("type") String type){
		List<Response> responses = new ArrayList<Response>();
		List<Schedule> schedules = scheduleService.findByType(type);
		schedules.stream().forEach((schedule) -> responses.add(this.findByScheduleId(schedule.getScheduleId())));
		return responses;
	}
	
	@GetMapping(path="employee/{employeeId}")
	public List<Response> findByEmployeeId(@PathVariable("employeeId") Long employeeId){
		List<Response> responses = new ArrayList<Response>();
		List<Schedule> schedules = scheduleService.findByEmployeeId(employeeId);
		schedules.stream().forEach((schedule) -> responses.add(this.findByScheduleId(schedule.getScheduleId())));
		return responses;
	}
	
	@GetMapping(path="startdate/{startDate}")
	public List<Response> findByStartDate(@PathVariable("startDate") Date startDate){
		List<Response> responses = new ArrayList<Response>();
		List<Schedule> schedules = scheduleService.findByStartDate(startDate);
		schedules.stream().forEach((schedule) -> responses.add(this.findByScheduleId(schedule.getScheduleId())));
		return responses;
	}
	
	@GetMapping(path="enddate/{endDate}")
	public List<Response> findByEndDate(@PathVariable("endDate")  Date endDate){
		List<Response> responses = new ArrayList<Response>();
		List<Schedule> schedules = scheduleService.findByEndDate(endDate);
		schedules.stream().forEach((schedule) -> responses.add(this.findByScheduleId(schedule.getScheduleId())));
		return responses;
	}
	
	@GetMapping(path="maximumstartdate/{startDate}")
	public List<Response> findByMaximumStartDate(@PathVariable("startDate")  Date startDate){
		List<Response> responses = new ArrayList<Response>();
		List<Schedule> schedules = scheduleService.findByMaximumStartDate(startDate);
		schedules.stream().forEach((schedule) -> responses.add(this.findByScheduleId(schedule.getScheduleId())));
		return responses;
	}
	
	@GetMapping(path="maximumenddate/{endDate}")
	public List<Response> findByMaximumEndDate(@PathVariable("endDate")  Date endDate){
		List<Response> responses = new ArrayList<Response>();
		List<Schedule> schedules = scheduleService.findByMaximumEndDate(endDate);
		schedules.stream().forEach((schedule) -> responses.add(this.findByScheduleId(schedule.getScheduleId())));
		return responses;
	}
	
	@GetMapping(path="minimumstartdate/{startDate}")
	public List<Response> findByMinimumStartDate(@PathVariable("startDate")  Date startDate){
		List<Response> responses = new ArrayList<Response>();
		List<Schedule> schedules = scheduleService.findByMaximumStartDate(startDate);
		schedules.stream().forEach((schedule) -> responses.add(this.findByScheduleId(schedule.getScheduleId())));
		return responses;
	}
	
	@GetMapping(path="minimumenddate/{endDate}")
	public List<Response> findByMinimumEndDate(@PathVariable("endDate")  Date endDate){
		List<Response> responses = new ArrayList<Response>();
		List<Schedule> schedules = scheduleService.findByMinimumEndDate(endDate);
		schedules.stream().forEach((schedule) -> responses.add(this.findByScheduleId(schedule.getScheduleId())));
		return responses;
	}
	
}
