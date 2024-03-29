package com.yyouss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yyouss.modele.FactoryMethod;

public class CoffeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public CoffeeController() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FactoryMethod factory = new FactoryMethod(request.getSession());
		String str = request.getParameter("Id");
		
		if (str != null && !str.isEmpty())
			request.setAttribute("coffee", factory.getCoffeeById(Long.parseLong(str)));
		
		request.getRequestDispatcher("/WEB-INF/CoffeeView.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/CoffeeView.jsp").forward(request, response);
	}

}
