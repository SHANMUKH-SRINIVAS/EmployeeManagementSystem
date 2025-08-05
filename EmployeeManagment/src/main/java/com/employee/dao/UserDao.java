package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employee.model.User;
import com.employee.utils.Constants;
import com.employee.utils.DBConnection;

public class UserDao {
	
	public void saveUser(User user) {
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.INSERT_USER);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean validateUser(User user) {
		
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.GET_USER);
			statement.setString(1, user.getEmail());
			ResultSet rs = statement.executeQuery();
			String email=null;
			String password=null;
			while(rs.next()) {
				 email= rs.getString(1);
				 password = rs.getString(2);
			}
			return user.getEmail().equals(email) && user.getPassword().equals(password);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
		
	}

}
