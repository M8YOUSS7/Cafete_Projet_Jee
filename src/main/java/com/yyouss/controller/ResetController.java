package com.yyouss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yyouss.modele.FactoryMethod;

public class ResetController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public ResetController() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FactoryMethod mesMethodes = new FactoryMethod(request.getSession());
		mesMethodes.reset();
		response.sendRedirect("Accueil");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FactoryMethod mesMethodes = new FactoryMethod(request.getSession());
		mesMethodes.reset();
		response.sendRedirect("Accueil");
	}
}
