package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Utilisateur;

public class DBUtilisateur {
	public List<Utilisateur> select() throws SQLException {
		Connection con = (new ConnectionDB()).getCon();
		List<Utilisateur> list = new ArrayList<Utilisateur>();
		String statementSELECT = "SELECT Nom, email, password, age, adress FROM `users`";
		PreparedStatement statement = con.prepareStatement(statementSELECT);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			list.add(new Utilisateur(result.getString(1), result.getString(2), result.getString(3), result.getInt(4),
					result.getString(5)));
		}
		result.close();
		statement.close();
		return list;
	}

	public Utilisateur isExiste(String pEmail, String pPassword) throws SQLException {
		List<Utilisateur> list = select();
		for (Utilisateur user : list) {
			if (user.getEmail().contentEquals(pEmail) && user.getPassword().contentEquals(pPassword))
				return user;
		}
		return null;
	}

	public boolean updateClient(String pNomNv, String pEmailNv, String pPasswordNv, int pAgeNv, String pAdressNv,
			String pEmail) {
		Connection con = (new ConnectionDB()).getCon();
		String updateStatement = "UPDATE `users` SET `Nom`='" + pNomNv + "' ,`email`='" + pEmailNv + "' ,`password`='"
				+ pPasswordNv + "' ,`age` = " + pAgeNv + " ,`adress`='" + pAdressNv + "' WHERE `email` = '" + pEmail
				+ "'";
		Boolean tmpResulst = false;
		try {
			PreparedStatement statement = con.prepareStatement(updateStatement);
			int result = statement.executeUpdate(updateStatement);
			if (result == 1) {
				tmpResulst = true;
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmpResulst;
	}

}
