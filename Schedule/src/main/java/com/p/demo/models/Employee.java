package com.p.demo.models;

import java.math.BigDecimal;
import java.sql.Date;


public class Employee {

	private Long employeeId;
	private String firstName;
	private String midName;
	private String lastName;
	private String jobName;
	private Long mobilePhone;
	private String address;
	private String sex;
	private Date birthDate;
	private Long managerId;
	private Date hireDate;
	private int salary;
	private BigDecimal evaluation;
	
	
	public BigDecimal getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(BigDecimal evaluation) {
		this.evaluation = evaluation;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee() {
		super();
	}

	

	public Employee(String firstName, String midName, String lastName, String jobName, Long mobilePhone, String sex,
			Date birthDate, Long managerId, Date hireDate, int salary, BigDecimal evaluation, String address) {
		super();
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.jobName = jobName;
		this.mobilePhone = mobilePhone;
		this.sex = sex;
		this.birthDate = birthDate;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.salary = salary;
		this.evaluation = evaluation;
		this.address = address;
	}

	public Employee(Long employeeId, String firstName, String midName, String lastName, String jobName,
			Long mobilePhone, String sex, Date birthDate, Long managerId, Date hireDate, int salary,
			BigDecimal evaluation, String address) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.jobName = jobName;
		this.mobilePhone = mobilePhone;
		this.sex = sex;
		this.birthDate = birthDate;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.salary = salary;
		this.evaluation = evaluation;
		this.address = address;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Long getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(Long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
	

}
