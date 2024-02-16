package com.yyouss.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yyouss.modele.*;

public class NescoffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NescoffController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("title", "Welcome to Nescoff WebApp");
			FactoryMethod mesMethodes = new FactoryMethod(request.getSession());
			
			request.setAttribute("coffeeConsumed", mesMethodes.getPreferedCoffee());
			request.setAttribute("coffeeDegustedNb", mesMethodes.getCoffeeDegustedNb());
			request.setAttribute("producers", mesMethodes.getProductorsAndMeans());
		} catch (IllegalArgumentException e) {
			request.setAttribute("error", e.getMessage());
		} 
		this.getServletContext().getRequestDispatcher("/WEB-INF/NescoffView.jsp").forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/NescoffView.jsp").forward(request, response);
	}
}
