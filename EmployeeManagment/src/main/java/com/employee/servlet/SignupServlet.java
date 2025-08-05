package com.employee.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.employee.dao.UserDao;
import com.employee.model.User;
import com.employee.utils.Constants;
import com.employee.utils.DBConnection;


@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String confirmPassword=req.getParameter("confrimPassword");
		
		User user=new User(email,password);
		
		
		UserDao userDao=new UserDao();
		userDao.saveUser(user);
		
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
		requestDispatcher.forward(req, resp);
	}
	
	

}
