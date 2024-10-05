package com.p.demo.controller;

import java.math.BigDecimal;
import java.sql.Date;
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

import com.p.demo.entity.Employee;
import com.p.demo.service.EmployeeService;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.savEmployee(employee);
	}
	
	@PutMapping(path="{employeeId}")
	public Optional<Employee> updateEmployeeById(@RequestBody Employee employee, @PathVariable("employeeId") Long employeeId){
		return employeeService.updateEmployeeById(employee, employeeId);
	}
	
	@DeleteMapping(path="{employeeId}")
	public String deleteEmployeeById(@PathVariable("employeeId") Long employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}
	
	@GetMapping(path="{employeeId}")
	public Optional<Employee> findByEmployeeId(@PathVariable("employeeId") Long employeeId){
		return employeeService.findByEmployeeId(employeeId);
	}
	
	@GetMapping(path="all")
	public List<Employee> findAllEmployees(){
		return employeeService.findAllEmployees();
	}
	
	@GetMapping(path="job/{jobName}")
	public List<Employee> findByJobName(@PathVariable("jobName") String jobName){
		return employeeService.findByJobName(jobName);
	}
	
	@GetMapping(path="sex/{sex}")
	public List<Employee> findBySex(@PathVariable("sex") String sex){
		return employeeService.findBySex(sex);
	}
	
	@GetMapping(path="salary/{salary}")
	public List<Employee> findBySalary(@PathVariable("salary") int salary){
		return employeeService.findBySalary(salary);
	}
	
	@GetMapping(path="hireDate/{hireDate}")
	public List<Employee> findByHireDate(@PathVariable("hireDate") Date hireDate){
		return employeeService.findByHireDate(hireDate);
	}
	
	@GetMapping(path="minimumsalary/{salary}")
	public List<Employee> findByMinimumSalary(@PathVariable("salary") int salary){
		return employeeService.findByMinimumSalary(salary);
	}
	
	@GetMapping(path="maximumsalary/{salary}")
	public List<Employee> findByMaximumSalary(@PathVariable("salary") int salary){
		return employeeService.findByMaximumSalary(salary);
	}
	
	@GetMapping(path="minimumhireDate/{hireDate}")
	public List<Employee> findByMinimumHireDate(@PathVariable("hireDate") Date hireDate){
		return employeeService.findByMinimumHireDate(hireDate);
	}
	
	@GetMapping(path="maximumhireDate/{hireDate}")
	public List<Employee> findByMaximumHireDate(@PathVariable("hireDate") Date hireDate){
		return employeeService.findByMaximumHireDate(hireDate);
	}
	
	@GetMapping(path="minimumevaluation/{evaluation}")
	public List<Employee> findByMinimumEvaluation(@PathVariable("evaluation") BigDecimal evaluation){
		return employeeService.findByMinimumEvaluation(evaluation);
	}
	
	@GetMapping(path="maximumevaluation/{evaluation}")
	public List<Employee> findByMaximumEvaluation(@PathVariable("evaluation") BigDecimal evaluation){
		return employeeService.findByMaximumEvaluation(evaluation);
	}
}
