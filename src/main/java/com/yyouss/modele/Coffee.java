package com.yyouss.modele;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class Coffee implements Serializable {
	private static final long serialVersionUID = 1L;
	private static long idCpt=0;
	long id;
	String name;
	Productor productor;
	int intensity;
	int amertume;
	int acidite;
	int body;
	int torrefaction;
	String description;
	int note;
	
	public Coffee () {
		this.id = idCpt++;
	}
	
	public Coffee (String name, Productor productor) {
		this.name = name;
		this.productor = productor;
	}
	
	public Coffee(HttpServletRequest request) {
		this.id = idCpt++;
		this.name = request.getParameter("name");
		this.intensity = Integer.parseInt(request.getParameter("intensitee"));
		this.amertume = Integer.parseInt(request.getParameter("amertume"));
		this.acidite = Integer.parseInt(request.getParameter("acidite"));
		this.body = Integer.parseInt(request.getParameter("corps"));
		this.torrefaction = Integer.parseInt(request.getParameter("torrefaction"));
		this.description = request.getParameter("description");
		this.note = Integer.parseInt(request.getParameter("note"));
	}
	
	public Coffee(Coffee coffee) {
		this.id = coffee.id;
		this.name = coffee.name;
		this.productor = coffee.productor;
		this.intensity = coffee.intensity;
		this.amertume = coffee.amertume;
		this.acidite = coffee.acidite;
		this.body = coffee.body;
		this.torrefaction = coffee.torrefaction;
		this.description = coffee.description;
		this.note = coffee.note;
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



	public Productor getProductor() {
		return productor;
	}



	public void setProductor(Productor productor) {
		this.productor = productor;
	}



	public int getIntensity() {
		return intensity;
	}



	public void setIntensity(int intensity) throws IllegalArgumentException {
		if(intensity >= 0 && intensity <= 10) {
			this.intensity = intensity;			
		} else { throw new IllegalArgumentException("intensity must be between 1 and 10");}
	}



	public int getAmertume() {
		return amertume;
	}



	public void setAmertume(int amertume) {
		if (amertume > 0 && amertume <= 5) {
			this.amertume = amertume;
		} else {
			throw new IllegalArgumentException("amertume must be between 1 and 5");
		}
	}



	public int getAcidite() {
		return acidite;
	}



	public void setAcidite(int acidite) {
		if (acidite > 0 && acidite <= 5) {
			this.acidite = acidite;
		} else {
			throw new IllegalArgumentException("acidite must be between 1 and 5");
		}
	}



	public int getBody() {
		return body;
	}



	public void setBody(int body) {
		if (body > 0 && body <= 5) {
			this.body = body;
		} else {
			throw new IllegalArgumentException("body must be between 1 and 5");
		}
	}



	public int getTorrefaction() {
		return torrefaction;
	}



	public void setTorrefaction(int torrefaction) {
		if (torrefaction > 0 && torrefaction <= 5) {
			this.torrefaction = torrefaction;
		} else {
			throw new IllegalArgumentException("torrefaction must be between 1 and 5");
		}
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getNote() {
		return note;
	}



	public void setNote(int note) {
		if (note >= 0 && note <= 5) {
			this.note = note;
		} else {
			throw new IllegalArgumentException("note must be between 0 and 5");
		}
	}



	@Override
	public String toString() {
		return "Cafee [id="+ id +", name=" + name + ", productor=" + productor.getName() + ", intensity=" + intensity + ", amertume="
				+ amertume + ", acidite=" + acidite + ", body=" + body + ", torrefaction=" + torrefaction
				+ ", description=" + description + ", note=" + note + "]";
	}
	
	public boolean equals(Coffee  cafee) {
		return this.id == cafee.id;
	}
	
	public String toHtml() {
		return "<div class=\"cafee\">" + "<h3>" + name + "</h3>" + "<p><a href='Producteur?Id="+productor.getId()+"'>Productor: " + productor.getName() + "</a></p>"
				+ "<p>Intensity: " + intensity + "</p>" + "<p>Amertume: " + amertume + "</p>" + "<p>Acidite: " + acidite
				+ "</p>" + "<p>Body: " + body + "</p>" + "<p>Torrefaction: " + torrefaction + "</p>"
				+ "<p>Description: " + description + "</p>" + "<p>Note: " + note + "</p>" + "</div>";
	}
}
