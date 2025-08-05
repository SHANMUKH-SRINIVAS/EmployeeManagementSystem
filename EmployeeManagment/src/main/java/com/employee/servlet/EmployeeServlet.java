package com.employee.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;


@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		EmployeeDao employeeDao=new EmployeeDao();
		List<Employee> allEmployees=employeeDao.getAllEmployees();
		req.setAttribute("empList", allEmployees);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("employees.jsp");
		requestDispatcher.forward(req, resp);
	}
	
}
