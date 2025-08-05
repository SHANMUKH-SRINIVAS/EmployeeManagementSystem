package com.employee.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;


@WebServlet("/addEmployee")
public class AddEmployee extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email=req.getParameter("email");
		String phone_number = req.getParameter("phone_number");
		double salary=Double.parseDouble(req.getParameter("salary"));
		
		Employee emp=new Employee(name,age,email,phone_number,salary);
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.addEmployee(emp);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("employees");
		requestDispatcher.forward(req, resp);
	}
}
