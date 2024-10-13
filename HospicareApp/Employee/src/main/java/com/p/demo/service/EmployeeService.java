package com.p.demo.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.demo.entity.Employee;
import com.p.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee savEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Optional<Employee> updateEmployeeById(Employee employee,Long employeeId){
		employeeRepository.updateEmployeeById(employeeId, employee.getFirstName(), employee.getMidName(), employee.getLastName(), employee.getJobName(), employee.getMobilePhone(), employee.getSex(), employee.getBirthDate(), employee.getManagerId(), employee.getHireDate(), employee.getSalary(), employee.getEvaluation(),employee.getAddress());
		return employeeRepository.findById(employeeId);
	}
	
	public String deleteEmployeeById(Long employeeId) {
		if(employeeRepository.existsById(employeeId)) {
			employeeRepository.deleteById(employeeId);
			return "{\"status\":1}";
		}
		else {
			return "{\"status\":0}";
		}
	}
	
	public Optional<Employee> findByEmployeeId(Long employeeId){
		return employeeRepository.findById(employeeId);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public List<Employee> findByJobName(String jobName){
		return employeeRepository.findByJobName(jobName);
	}
	
	public List<Employee> findBySex(String sex){
		return employeeRepository.findBySex(sex);
	}
	
	public List<Employee> findBySalary(int salary){
		return employeeRepository.findBySalary(salary);
	}
	
	public List<Employee> findByHireDate(Date hireDate){
		return employeeRepository.findByHireDate(hireDate);
	}
	
	public List<Employee> findByMinimumSalary(int salary){
		return employeeRepository.findByMinimumSalary(salary);
	}
	
	public List<Employee> findByMaximumSalary(int salary){
		return employeeRepository.findByMaximumSalary(salary);
	}
	
	public List<Employee> findByMinimumHireDate(Date hireDate){
		return employeeRepository.findByMinimumHireDate(hireDate);
	}
	
	public List<Employee> findByMaximumHireDate(Date hireDate){
		return employeeRepository.findByMaximumHireDate(hireDate);
	}
	
	public List<Employee> findByMinimumEvaluation(BigDecimal evaluation){
		return employeeRepository.findByMinimumEvaluation(evaluation);
	}
	
	public List<Employee> findByMaximumEvaluation(BigDecimal evaluation){
		return employeeRepository.findByMaximumEvaluation(evaluation);
	}

}
