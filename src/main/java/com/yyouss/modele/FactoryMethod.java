package com.yyouss.modele;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class FactoryMethod {
	HttpSession session;
	ArrayList<Productor> productors;
	int coffeeDegustedNb;
	
	public FactoryMethod(HttpSession session) {
		this.session = session;
		init();
	}
	
	public void exit() {
		session.setAttribute("coffeeDegustedNb", coffeeDegustedNb);
		session.setAttribute("preferedCoffee", getPreferedCoffee());
		session.setAttribute("productors", productors);
	}

	private void init() {
		if (session.getAttribute("productors") != null) {
			productors = (ArrayList<Productor>) session.getAttribute("productors");
		} else {
	        productors = new ArrayList<Productor>();
		}
		
		if (session.getAttribute("coffeeDegustedNb") != null) {
			coffeeDegustedNb = (int) session.getAttribute("coffeeDegustedNb");
		} else {
			coffeeDegustedNb = 0;
		}
	}
	
	public ArrayList<Coffee> getCoffees() {
		return productors.stream().map(Productor::getCoffees).reduce(new ArrayList<Coffee>(), (acc, list) -> {
					acc.addAll(list);
					return acc;
				});
	}
	
	public ArrayList<Coffee> getCoffeesOrderedBy(String orderBy) {
		ArrayList<Coffee> coffees = getCoffees();
		orderBy = orderBy.toLowerCase();
		
		switch (orderBy) {
		case "note":
			coffees.sort((c1, c2) -> c2.getNote() - c1.getNote());
			break;
		case "intensite":
			coffees.sort(Comparator.comparing(Coffee::getIntensity));
			break;
		case "acidite":
			coffees.sort(Comparator.comparing(Coffee::getAcidite));
			break;
		case "amertume":
			coffees.sort(Comparator.comparing(Coffee::getAmertume));
			break;
		case "corps":
			coffees.sort(Comparator.comparing(Coffee::getBody));
			break;
		case "torrefaction":
			coffees.sort(Comparator.comparing(Coffee::getTorrefaction));
			break;
		case "id":
			coffees.sort(Comparator.comparing(Coffee::getId));
			break;
		default:
			coffees.sort(Comparator.comparing(Coffee::getName));
			break;
		}

		return coffees;
	}

	public ArrayList<Coffee> getPreferedCoffee() {
		ArrayList<Coffee> coffees = getCoffees();
		
		coffees.sort((c1, c2) -> c2.getNote() - c1.getNote());
		
		
		return coffees.stream().limit(5).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	}
	
	public Coffee getCoffeeById(long id) {
        return getCoffees().stream().filter(coffee -> coffee.getId() == id).findFirst().orElse(null);
    }
	
	
	public void addProductor(Productor productor) {
        productors.add(productor);
    }
	
	public Productor getProductorById(long id) {
		return productors.stream().filter(productor -> productor.getId() == id).findFirst().orElse(null);
    }
	
	public Productor getProductorByName(String name) {
		return productors.stream().filter(productor -> productor.getName() == name).findFirst().orElse(null);
	}

	public ArrayList<Productor> getProductors() {
		productors.sort(Comparator.comparing(Productor::noteMean));
		return productors;
	}

	public int getCoffeeDegustedNb() {
		return coffeeDegustedNb;
	}

	public void setCoffeeDegustedNb(int coffeeDegustedNb) {
		this.coffeeDegustedNb = coffeeDegustedNb;
	}
	
	public void reset() {
		session.invalidate();
	}
	
	public HashMap<String, Double> getProductorsAndMeans() {
		HashMap<String, Double> productorsAndMeans = new HashMap<String, Double>();
        productors.forEach(productor -> productorsAndMeans.put(productor.getName(), productor.noteMean()));
        return productorsAndMeans;
	}
}
