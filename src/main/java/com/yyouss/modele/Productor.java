package com.yyouss.modele;

import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Productor implements Serializable {
	private static final long serialVersionUID = 1L;
	private static long idCpt=0;
	long id;
	String name;
	String country;
	ArrayList<Coffee > caffees;
	
	public Productor() {
		caffees = new ArrayList<Coffee >();
		this.id = idCpt++;
	}
	
	public Productor(Productor productor) {
		this.id = productor.id;
		this.name = productor.name;
		this.country = productor.country;
		this.caffees = new ArrayList<Coffee >();
		this.caffees = productor.caffees;
	}
	
	public Productor(String name, String country) {
		this();
		this.name = name;
		this.country = country;
	}
	
	
	public long getId() {
		return id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getCountry() {
		return country;
	}


	public ArrayList<Coffee > getCoffees() {
		return caffees;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Coffee  getCoffeeById(long id) {
		return caffees.stream().filter(cafee -> cafee.getId() == id).findFirst().orElse(null);
	}
	
	public void addCoffee(Coffee  cafee) {
		if(cafee instanceof Coffee && !caffees.contains(cafee)) {
			cafee.setProductor(this);
			caffees.add(cafee);
		} else
			throw new IllegalArgumentException("cafee must be an instance of Cafee");
	}
	
	public void removeCoffee(long id) {
		caffees.removeIf(cafee -> cafee.getId() == id);
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Productor [id="+ id +", name=" + name + ", country=" + country + ", caffees={");
		caffees.forEach(cafee -> sb.append(cafee.getName() + ", "));
		sb.delete(sb.length()-2, sb.length());
		sb.append("}]");
		
		return sb.toString();
	}
	
	public String toHtml() {
		StringBuilder sb = new StringBuilder("<div class=\"productor\">");
		sb.append("<h3>" + name + "</h3>");
		sb.append("<p>" + country + "</p>");
		sb.append("<ul>");
		caffees.forEach(cafee -> sb.append(cafee.getName()));
		sb.append("</ul>");
		sb.append("</div>");

		return sb.toString();
	}
	
	public boolean equals(Productor productor) {
		return this.name == productor.name && this.country == productor.country;
	}
	
	public double noteMean() {
		return caffees.stream().mapToInt(cafee -> cafee.getNote()).average().orElse(0);
	}
}
