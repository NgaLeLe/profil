package com.control.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ajouterProduit")
public class AjouterProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjouterProduit() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/com.vue/nouveauProduit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		List<String> listProduit = new ArrayList<String>();
		listProduit = (List<String>) session.getAttribute("listeDeProduit");
		String produitNouveau = request.getParameter("iptNomProduit");
		if (produitNouveau != null && !produitNouveau.isEmpty()) {
			if (!produitExist(listProduit, produitNouveau)) {
				listProduit.add(produitNouveau);
				session.setAttribute("listeDeProduit", listProduit);
				session.setAttribute("isAjoute", "OK");
				request.getRequestDispatcher("/com.vue/espaceUser.jsp").forward(request, response);
			} else {
				session.setAttribute("isAjouter", "NON");
				doGet(request, response);
			}
		} else {
			session.setAttribute("error", "1");
			doGet(request, response);
		}
	}

	private boolean produitExist(List<String> list, String nomProduit) {
		for (String str : list) {
			if (str.equalsIgnoreCase(nomProduit)) {
				return true;
			}
		}
		return false;
	}
}
