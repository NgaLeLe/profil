package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Client;


public class DBClient {
	
public List<Client> select() throws SQLException {
	List<Client> list = new ArrayList<Client>();
	Connection con = (new ConnectionDB()).getCon();
	String statementSELECT = "SELECT * FROM `client`";
	PreparedStatement statement = con.prepareStatement(statementSELECT);
	ResultSet result = statement.executeQuery();

	while (result.next()) {
		list.add(new Client(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5)));
	}
	result.close();
	statement.close();
	return list;
}
public Client selectById(int id) throws SQLException {
	Connection con = (new ConnectionDB()).getCon();
	Client client = null;
	String statementSELECT = "SELECT * FROM `client` WHERE `id_client` =" + id + ";";
	PreparedStatement statement = con.prepareStatement(statementSELECT);
	ResultSet result = statement.executeQuery();

	while (result.next()) {
		client = new Client(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5));
	}
	result.close();
	statement.close();
	return client;
}
}
