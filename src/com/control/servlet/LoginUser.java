package com.control.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Utilisateur;
import com.database.ConnectionDB;
import com.database.DBUtilisateur;

@WebServlet("/loginUser")
public class LoginUser extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public LoginUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/com.vue/loginUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
//		String emailSession = (String) session.getAttribute("email");
//		String passwordSession = (String) session.getAttribute("password");

		String emailRes = (String) request.getParameter("iptEmail");
		String passwordRes = (String) request.getParameter("iptPassword");
		System.out.println("Request: " + emailRes + "  " + passwordRes);
		DBUtilisateur connnect = new DBUtilisateur();

		if (emailRes != null && passwordRes != null) {
//			if (emailRes.contentEquals(userDB.) && passwordRes.contentEquals(passwordSession)) {
			Utilisateur userDB;
			try {
				userDB = connnect.isExiste(emailRes, passwordRes);
				if (userDB != null) {
					session.setAttribute("error", "");
					session.setAttribute("nom", userDB.getNom());
					session.setAttribute("email", userDB.getEmail());
					session.setAttribute("password", userDB.getPassword());
					session.setAttribute("adress", userDB.getAdress());
					session.setAttribute("age", userDB.getAge());
					System.out.println(userDB.getEmail() + " - " + userDB.getNom() + " - " + userDB.getPassword());
					response.sendRedirect(request.getContextPath()+"/espaceUser");
				} else {
					session.setAttribute("error", "2");
					doGet(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			session.setAttribute("error", "1");
			doGet(request, response);
		}
	}

}
