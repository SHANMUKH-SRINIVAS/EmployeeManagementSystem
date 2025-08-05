package com.employee.servlet;

import java.io.IOException;

import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empId=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email=req.getParameter("email");
		String phone_number = req.getParameter("phone_number");
		double salary=Double.parseDouble(req.getParameter("salary"));
		
		Employee emp=new Employee(empId,name,age,email,phone_number,salary);
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.updateEmployee(emp);
		
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("employees");
//		requestDispatcher.forward(req, resp);
		
		resp.sendRedirect("employees");
	}
}
