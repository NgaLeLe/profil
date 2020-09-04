package com.control.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.bean.Client;
import com.bean.Commande;
import com.database.DBClient;
import com.database.DBCommande;

@WebServlet("/loginClient")
public class LoginClient extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	List<Client> clientPasConnect = new ArrayList<Client>();

	public LoginClient() throws SQLException {
		super();
		// creer list client de DB
		DBClient clientDB = new DBClient();
		clientPasConnect = clientDB.select();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/com.vue/loginClient.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBCommande commandeBD = new DBCommande();
		DBClient clientDB = new DBClient();
		Client client = null;
		List<Commande> lsCommandes = null;
		HttpSession session = request.getSession(true);
		session.setAttribute("error", "");

		String idRes = (String) request.getParameter("txtIdClient");
		String passwordRes = (String) request.getParameter("txtPassword");
		session.setAttribute("id", idRes);
		session.setAttribute("password", passwordRes);
		if (idRes != null && passwordRes != null) {
			int id = Integer.valueOf(idRes);
			try {
				client = clientDB.selectById(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (client != null) {
				if (Integer.valueOf(idRes) == client.getIdClient() && passwordRes.contentEquals(client.getPassword())) {
					try {
						lsCommandes = commandeBD.selectByClient(client.getIdClient());
					} catch (SQLException e) {
						e.printStackTrace();
					}
					//remove client qui vient de connecter
					clientPasConnect.removeIf(c -> (c.getIdClient()==Integer.valueOf(idRes)));
					
					session.setAttribute("error", "");
					session.setAttribute("client", client);
					session.setAttribute("listCommande", lsCommandes);
					session.setAttribute("clientPasConnect", clientPasConnect);
					request.getRequestDispatcher("/com.vue/listCommande.jsp").forward(request, response);
				} else {
					session.setAttribute("error", "2");
					doGet(request, response);
				}
			} else {
				session.setAttribute("error", "1");
				doGet(request, response);
			}
		}

	}
}
