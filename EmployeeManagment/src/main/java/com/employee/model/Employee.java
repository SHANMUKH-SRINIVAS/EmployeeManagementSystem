package com.employee.model;

public class Employee {

	private int empId;
	private String name;
	private int age;
	private String email;
	private String phone_number;
	private double salary;
	
	
	public Employee() {
		
	}

	

	public Employee(String name, int age, String email, String phone_number, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone_number = phone_number;
		this.salary = salary;
	}



	public Employee(int empId, String name, int age, String email, String phone_number, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone_number = phone_number;
		this.salary = salary;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", email=" + email + ", phone_number="
				+ phone_number + ", salary=" + salary + "]";
	}
	
}
