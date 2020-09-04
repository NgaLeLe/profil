package com.control.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/disconnect")
public class Disconnect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Disconnect() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String isConnect = (String) session.getAttribute("isConnected");
		if (isConnect == "true") {
			request.getRequestDispatcher("/com.vue/afficherConnected.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/com.vue/formulaire.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession newsession = request.getSession(false);
	    if (newsession != null) 
	    {
	    	newsession.setAttribute("nom", "");
	    	newsession.setAttribute("age", "");
	    	newsession.setAttribute("email", "");
	    	newsession.setAttribute("password", "");
	    	newsession.setAttribute("error", "");
	         newsession.invalidate();
	    }
	    
	   response.sendRedirect("/profil/");
	}

}
