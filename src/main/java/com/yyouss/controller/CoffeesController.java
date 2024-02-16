package com.yyouss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yyouss.modele.FactoryMethod;

public class CoffeesController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public CoffeesController() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FactoryMethod factory = new FactoryMethod(request.getSession());
		String orderBy = request.getParameter("orderBy");
		if (orderBy != null && !orderBy.isEmpty())
			request.setAttribute("coffees", factory.getCoffeesOrderedBy(orderBy));
		else
			request.setAttribute("coffees", factory.getCoffeesOrderedBy(""));
			
		
		request.getRequestDispatcher("/WEB-INF/CoffeesView.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("coffees.jsp").forward(request, response);
	}
}
