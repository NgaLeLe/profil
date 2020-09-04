package com.control.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.ConnectionDB;
import com.database.DBClient;
import com.database.DBUtilisateur;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUser() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/com.vue/modiferInfoUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupère var de session
		HttpSession session = request.getSession(true);
		String nomSession = (String) session.getAttribute("nom");
		String emailSession = (String) session.getAttribute("email");
		String passwordSession = (String) session.getAttribute("password");
		String adressSession = (String) session.getAttribute("adress");
		int ageSession = (Integer) session.getAttribute("age");
//		System.out.println("Session: " + nomSession + " " + emailSession + " " + passwordSession + " " + adressSession + " " + ageSession );
		// r"cupère var de formulaire
		String nomResq = (String) request.getParameter("iptNom");
		String emailResq = (String) request.getParameter("iptEmail");
		String passwordResq = (String) request.getParameter("iptPassword");
		String adressResq = (String) request.getParameter("iptAdress");
		String ageResq = (String) request.getParameter("iptAge");
		String nomNv = "";
		String emailNv = "";
		String passwordNv = "";
		String adressNv = "";
		int ageNv = 0;
		if (!nomResq.isEmpty()) {
			if (!nomResq.equals(nomSession)) {
				session.setAttribute("nom", nomResq); // affecter nv value
				nomNv = nomResq.toString();
				System.out.println("nom nv" + nomNv);
			} else {
				nomNv = nomSession;
			}
		} else {
			session.setAttribute("error", "1");
		}
		if (emailResq != null) {
			if (!emailResq.equals(emailSession)) {
				session.setAttribute("email", emailResq); // affecter nv value
				emailNv = emailResq;
				System.out.println("email nv " + nomNv);
			} else {
				emailNv = emailSession;
			}
		} else {
			session.setAttribute("error", "2");
		}
		if (adressResq != null) {
			if (!adressResq.equals(adressSession)) {
				session.setAttribute("adress", adressResq); // affecter nv value
				adressNv = adressResq;
				System.out.println("adress nv " + adressNv);
			} else {
				adressNv = adressSession;
			}
		} else {
			session.setAttribute("error", "3");
		}
		if (passwordResq != null) {
			if (!passwordResq.equals(passwordSession)) {
				session.setAttribute("password", passwordResq); // affecter nv value
				passwordNv = passwordResq;
				System.out.println("pass nv " + passwordNv);
			} else {
				passwordNv = passwordSession;
			}
		} else {
			session.setAttribute("error", "4");
		}
		if (ageResq != null) {int ageInt = Integer.valueOf(ageResq);
			if ( ageInt != ageSession && ageInt >= 18 && ageInt <= 95 ) {
				session.setAttribute("age", ageInt); // affecter nv value
				ageNv = ageInt;
				System.out.println("pass nv " + ageNv);
			} else {
				ageNv = ageSession;
			}
		} else {
			session.setAttribute("error", "5");
		}
		DBUtilisateur connect = new DBUtilisateur();
		boolean update = connect.updateClient(nomNv, emailNv, passwordNv, ageNv, adressNv, emailSession);
		 if (update) {session.setAttribute("update", "OK");}
		doGet(request, response);
	}

}
