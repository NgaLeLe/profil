package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Utilisateur;

public class ConnectionDB {
	private Connection con = null;
	private String nomBD = "profils";
	private String url = "jdbc:mysql://localhost:3306/"+nomBD;
	private String username = "root";
	private String password = "";

	public Connection getCon() {
		return con;
	}

	public ConnectionDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver n'est pas recharge !");
		}
		try {
			con = (Connection) DriverManager.getConnection(url, username, password);
		//	System.out.println("Connexion reussie");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	}
