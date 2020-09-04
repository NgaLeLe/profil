package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Commande;

public class DBCommande {
	public List<Commande> select() throws SQLException {
		List<Commande> list = new ArrayList<Commande>();
		Connection con = (new ConnectionDB()).getCon();
		String statementSELECT = "SELECT * FROM `commande`;";
		PreparedStatement statement = con.prepareStatement(statementSELECT);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			list.add(new Commande(result.getInt(1), result.getInt(2), result.getString(3), result.getInt(4), result.getInt(5), result.getString(6)));
		}
		result.close();
		statement.close();
		return list;
	}
	public List<Commande> selectByClient(int pIdClient) throws SQLException {
		List<Commande> list = new ArrayList<Commande>();
		Connection con = (new ConnectionDB()).getCon();
		String statementSELECT = "SELECT * FROM `cmd` WHERE `id_client` = '" + pIdClient + "';";
		PreparedStatement statement = con.prepareStatement(statementSELECT);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			list.add(new Commande(result.getInt(1), result.getInt(2), result.getString(3), result.getInt(4), result.getInt(5), result.getString(6)));
		}
		result.close();
		statement.close();
		return list;
	}
}
