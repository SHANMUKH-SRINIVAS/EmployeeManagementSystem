package com.employee.servlet;

import java.io.IOException;

import com.employee.dao.EmployeeDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int empId=Integer.parseInt(req.getParameter("id"));
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.deleteEmployee(empId);
		
		
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("employees");
//		requestDispatcher.forward(req, resp);
		resp.sendRedirect("employees");
	}
}
