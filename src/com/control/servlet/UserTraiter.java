package com.control.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Client;
import com.database.DBClient;

@WebServlet("/espaceUser")
public class UserTraiter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public UserTraiter() {
		super();
		System.out.println("Constructeur Usertraiter");
	}
public void init(){
	System.out.println("méthode init");
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String nomUser = (String) session.getAttribute("nom");
		String emailUser = (String) session.getAttribute("email");
		if (( nomUser == null || nomUser.isEmpty() ) && ( emailUser == null || emailUser.isEmpty())) {
			response.sendRedirect(request.getContextPath() + "/loginUser");
		} else {
		DBClient dbClient = new DBClient();
		List<Client> listClient = null;
		try {
			listClient = dbClient.select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> listeDeProduit = new ArrayList<String>();
		listeDeProduit.add("adidas");
		listeDeProduit.add("Nike");
		listeDeProduit.add("One+8");
		listeDeProduit.add("Rouge à levre");
		listeDeProduit.add("armor");
		listeDeProduit.add("samsung");
		listeDeProduit.removeIf(produit -> (produit.charAt(0) == 'a'));
		session.setAttribute("listeDeProduit", listeDeProduit);
		session.setAttribute("listClient", listClient);
		request.getRequestDispatcher("/com.vue/espaceUser.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (request.getParameter("deconnecter") != null
				&& request.getParameter("deconnecter").equalsIgnoreCase("deconnecter")) {
			System.out.println("appuyer DECONNECTER s/page Espace User");
			session.setAttribute("nom", "");
			session.setAttribute("email", "");
			session.setAttribute("error", "");
			session.setAttribute("listeDeProduit", null);
			session.setAttribute("listClient", null);
			session.invalidate();
			response.sendRedirect(request.getContextPath() + "/loginUser");
//			request.getRequestDispatcher("/loginUser").forward(request, response);
		}
		//ajouter nouvelle produit
		if (request.getParameter("ajouter") != null && request.getParameter("ajouter").equalsIgnoreCase("ajouter")) {
			System.out.println("include page nouveau Produit");
			request.getRequestDispatcher("/com.vue/nouveauProduit.jsp").include(request, response);
		}
		//modifier
		if (request.getParameter("modifier") != null && request.getParameter("modifier").equalsIgnoreCase("modifier")) {
			System.out.println("Modifier info d'utilisateur");
			request.getRequestDispatcher("/com.vue/modiferInfoUser.jsp").forward(request, response);
		}
	}

 public void destroy() {
	 System.out.println("Destroy svl usertraiter");
 }
 public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 super.service(request, response);
	 System.out.println("Methode Service s/userTraiter ");
 }
}
