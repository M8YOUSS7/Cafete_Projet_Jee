package com.yyouss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yyouss.modele.FactoryMethod;
import com.yyouss.modele.Productor;

/**
 * Servlet implementation class AddProductor
 */
public class AddProductor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Page to add a productor");
		this.getServletContext().getRequestDispatcher("/WEB-INF/AddProductorView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FactoryMethod mesMethodes = new FactoryMethod(request.getSession());
		
		mesMethodes.addProductor(new Productor(request.getParameter("name"), request.getParameter("country")));
		
		mesMethodes.exit();
		response.sendRedirect("Accueil");
	}

}
