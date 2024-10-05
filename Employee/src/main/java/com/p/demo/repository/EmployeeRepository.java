package com.p.demo.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.p.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	List<Employee> findByJobName(String jobName);
	List<Employee> findBySex(String sex);
	List<Employee> findBySalary(int salary);
	List<Employee> findByHireDate(Date hireDate);
	
	
	@Query("SELECT t FROM Employee t WHERE t.salary>?1")
	List<Employee> findByMinimumSalary(int salary);
	
	@Query("SELECT t FROM Employee t WHERE t.salary<?1")
	List<Employee> findByMaximumSalary(int salary);
	
	@Query("SELECT t FROM Employee t WHERE t.hireDate>?1")
	List<Employee> findByMinimumHireDate(Date hireDate);
	
	@Query("SELECT t FROM Employee t WHERE t.hireDate<?1")
	List<Employee> findByMaximumHireDate(Date hireDate);
	
	@Query("SELECT t FROM Employee t WHERE t.evaluation>?1")
	List<Employee> findByMinimumEvaluation(BigDecimal evaluation);
	
	@Query("SELECT t FROM Employee t WHERE t.evaluation<?1")
	List<Employee> findByMaximumEvaluation(BigDecimal evaluation);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Employee SET firstName=?2,midName=?3, lastName=?4, jobName=?5, mobilePhone=?6, sex=?7, birthDate=?8, managerId=?9, hireDate=?10, salary=?11,evaluation=?12,address=?13 WHERE employeeId=?1")
	void updateEmployeeById(Long employeeId,String firstName,String midName,String lastName,String jobName,Long mobilePhone,String sex,Date birthDate,Long managerId,Date hireDate,int salary,BigDecimal evaluation,String address);

}
