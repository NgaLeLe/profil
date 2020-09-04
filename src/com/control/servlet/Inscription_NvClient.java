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


@WebServlet("/inscription")
public class Inscription_NvClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Inscription_NvClient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/com.vue/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("iptNom");
		String email = request.getParameter("iptEmail");
		String password = request.getParameter("iptPassword");
		String age = request.getParameter("iptAge");
		String error = "";
		
		HttpSession session = request.getSession(true);
		session.setAttribute("nom", nom);
		session.setAttribute("email", email);
		session.setAttribute("age", age);
		session.setAttribute("password", password);
		session.setAttribute("error", error);
		System.out.println("nom = " + nom);
		System.out.println("email = " + email);
		System.out.println("pass = " + password);
		System.out.println("age = " + age);
		if (nom != null) {
			if (!email.isEmpty()) {
				CheckEmail ckEmail = new CheckEmail(email);
				if (ckEmail.isValide()) {
					if (password != null) {
						if (age != null) {
							int ageInt = Integer.valueOf(age);
							if (ageInt >= 18 && ageInt <= 95) {
								System.out.println(error);
								request.getRequestDispatcher("/com.vue/loginClient.jsp").forward(request, response);
							} else {//age n'est pas [18, 95]
								error = "6";
								session.setAttribute("error", error);
								doGet(request, response);
							}
						} else { //age = null
							age = "";
							error = "5";
							session.setAttribute("error", error);
							doGet(request, response);
						}
					} else { //pass = null
						password = "";
						error = "4";
						session.setAttribute("error", error);
						doGet(request, response);
					}
				} else { //adress email n'est pas bon
					error = "3";
					session.setAttribute("error", error);
					doGet(request, response);
				}
			}	else {//email = null
				email="";
				error = "2";
				session.setAttribute("error", error);
				doGet(request, response);
			}
		} else { //pas rempli le nom
			nom = "";
			error = "1"; 
			session.setAttribute("error", error);
			doGet(request, response);
		}
		System.out.println(error);
	}
	

}
