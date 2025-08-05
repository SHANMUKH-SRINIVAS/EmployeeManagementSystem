package com.employee.utils;

public class Constants {
	
	public static final String URL="jdbc:mysql://localhost:3306/projects";
	public static final String USERNAME="root";
	public static final String PASSWORD="admin";
	public static final String INSERT_USER="Insert into users values(?,?)";
	public static final String 	GET_USER="select * from users where email=?";
	public static final String GET_ALL_EMPLOYEES="select * from employees";
	public static final String SAVE_EMPLOYEE="insert into employees(name,age,email,phone_number,salary) values(?,?,?,?,?)";
	public static final String DELETE_EMPLOYEE="delete from employees where empId=?";
	public static final String GET_EMPLOYEE="select * from employees where empId=?";
	public static final String UPDATE_EMPLOYEE="update employees set name=?,age=?,email=?,phone_number=?,salary=? where empId=?";

}
