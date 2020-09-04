package com.control.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logique.business.CheckAdmin;
import com.logique.business.CheckEmail;

/**
 * Servlet implementation class Formulaire
 */
@WebServlet("/formulaire")
public class Formulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Formulaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("Do get Formulaire");
		request.getRequestDispatcher("/com.vue/formulaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("iptNom");
		String email = request.getParameter("iptEmail");
		String password = request.getParameter("iptPassword");
		String age = request.getParameter("iptAge");
		HttpSession session = request.getSession(true);
		session.setAttribute("nom", nom);
		session.setAttribute("email", email);
		session.setAttribute("age", age);
		session.setAttribute("password", password);
		CheckEmail checkEmail = new CheckEmail(email);
		CheckAdmin checkAdmin = new CheckAdmin(email, password);
		if (email != null) {
			if (checkEmail.isValide()) { // email est correct
				if (checkAdmin.isValide()) { // est un admin
					session.setAttribute("isConnected", true);
					session.setAttribute("error", "");
					request.getRequestDispatcher("/com.vue/adminConnected.jsp").forward(request, response);
				} else { // pas admin
					if (checkAdmin.isExist()) { //email d'admin exist mais password n'est pas correct
						session.setAttribute("isConnected", false);
						session.setAttribute("error", "4");
						doGet(request, response);
					} else
					if (nom != null && age != null) {
						if (Integer.valueOf(age) >= 18 && Integer.valueOf(age) <= 95) {
							session.setAttribute("isConnected", true);
							session.setAttribute("error", "");
							request.getRequestDispatcher("/com.vue/afficherConnected.jsp").forward(request, response);
						} else { //age n'est pas dans [18, 95]
							session.setAttribute("isConnected", false);
							session.setAttribute("error", "3");
							doGet(request, response);
						}
					} else { //nom ou age n'est pas rempli
						session.setAttribute("isConnected", false);
						session.setAttribute("error", "1");
						doGet(request, response);
					}
				}
			} else { //adress n'est pas correct, pas en forme xxx@ccc.ddd
				session.setAttribute("isConnected", false);
				session.setAttribute("error", "2");
				doGet(request, response);
			}

		}
	}
}