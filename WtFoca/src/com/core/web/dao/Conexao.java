package com.core.web.dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtfoca","root","1234");
		} catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.println("ERROR2");

			e.printStackTrace();
		}
		return con;
	}

}
