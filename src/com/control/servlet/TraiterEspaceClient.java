package com.control.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/espaceClient")
public class TraiterEspaceClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       public TraiterEspaceClient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/com.vue/listCommande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession(true);
	System.out.println("POST de traiter" + request.getParameter("deconnecter") );
		if (request.getParameter("deconnecter") != null &&
				request.getParameter("deconnecter").equalsIgnoreCase("deconnecter") ){
		System.out.println("appuyer DECONNECTER");
		session.setAttribute("id", "");
		session.setAttribute("password", "");
		session.setAttribute("error", "");
		session.setAttribute("client", "");
		session.setAttribute("listCommande", "");
		session.setAttribute("clientPasConnect", "");
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/loginClient");
	}
	}

}
