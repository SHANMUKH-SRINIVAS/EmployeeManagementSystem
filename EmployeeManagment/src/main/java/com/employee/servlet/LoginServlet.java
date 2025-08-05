package com.employee.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.employee.dao.UserDao;
import com.employee.model.User;
import com.employee.utils.Constants;
import com.employee.utils.DBConnection;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		User user=new User(email,password);
		
		UserDao userDao=new UserDao();
		boolean isValid = userDao.validateUser(user);
		
		if(isValid) {
			HttpSession session = req.getSession();
			String name =user.getEmail().split("@")[0];
			session.setAttribute("email", name);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("employees");
			requestDispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
			requestDispatcher.forward(req, resp);
		}
		
		
	}
	
	

}
