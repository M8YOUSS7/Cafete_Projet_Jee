package com.yyouss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yyouss.modele.Coffee;
import com.yyouss.modele.FactoryMethod;
import com.yyouss.modele.Productor;

/**
 * Servlet implementation class AddCoffee
 */
public class AddCoffee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCoffee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Page to add a coffee");
		FactoryMethod mesMethodes = new FactoryMethod(request.getSession());
		request.setAttribute("producers", mesMethodes.getProductors());
		this.getServletContext().getRequestDispatcher("/WEB-INF/AddCoffeeView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FactoryMethod mesMethodes = new FactoryMethod(request.getSession());
		Coffee newCoffee = new Coffee();
		newCoffee.setName(request.getParameter("name"));
		newCoffee.setIntensity(Integer.parseInt(request.getParameter("intensitee")));
		newCoffee.setAmertume(Integer.parseInt(request.getParameter("amertume")));
		newCoffee.setAcidite(Integer.parseInt(request.getParameter("acidite")));
		newCoffee.setBody(Integer.parseInt(request.getParameter("corps")));
		newCoffee.setTorrefaction(Integer.parseInt(request.getParameter("torrefaction")));
		newCoffee.setDescription(request.getParameter("description"));
		newCoffee.setNote(Integer.parseInt(request.getParameter("note")));
		
		mesMethodes.getProductorById(Integer.parseInt(request.getParameter("producer"))).addCoffee(newCoffee);
		mesMethodes.exit();
		response.sendRedirect("Accueil");
//		this.getServletContext().getRequestDispatcher("/WEB-INF/NescoffView.jsp").forward(request, response);
	}

}
