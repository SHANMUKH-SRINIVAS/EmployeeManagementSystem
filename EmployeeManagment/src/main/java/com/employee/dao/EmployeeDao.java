package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employee.model.Employee;
import com.employee.utils.Constants;
import com.employee.utils.DBConnection;

public class EmployeeDao {

	
	public List<Employee> getAllEmployees() {
		List<Employee>  employees=new ArrayList<>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.GET_ALL_EMPLOYEES);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int empId=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String email=rs.getString(4);
				String phoneNum=rs.getString(5);
				double salary=rs.getDouble(6);
				
				Employee emp=new Employee(empId,name,age,email,phoneNum,salary);
				employees.add(emp);
			}
			return employees;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;	
	}
	
	public void addEmployee(Employee employee) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.SAVE_EMPLOYEE);
			statement.setString(1,employee.getName());
			statement.setInt(2, employee.getAge());
			statement.setString(3, employee.getEmail());;
			statement.setString(4, employee.getPhone_number());
			statement.setDouble(5, employee.getSalary());
			statement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Employee getEmployee(int empId) {
		Connection connection;
		Employee emp=null;
		try {
			connection=DBConnection.getConnection();
			PreparedStatement statement=connection.prepareStatement(Constants.GET_EMPLOYEE);
			statement.setInt(1,empId);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				//int empId=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String email=rs.getString(4);
				String phoneNum=rs.getString(5);
				double salary=rs.getDouble(6);
				emp=new Employee(empId,name,age,email,phoneNum,salary);	
			}
			//return emp;
		}
		
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	
	
	public void deleteEmployee(int empId) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.DELETE_EMPLOYEE);
			statement.setInt(1,empId);
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void updateEmployee(Employee employee) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_EMPLOYEE);
			statement.setString(1,employee.getName());
			statement.setInt(2, employee.getAge());
			statement.setString(3, employee.getEmail());;
			statement.setString(4, employee.getPhone_number());
			statement.setDouble(5, employee.getSalary());
			statement.setInt(6, employee.getEmpId());
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}
}
