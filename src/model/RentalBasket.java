package model;

import java.util.ArrayList;

public class RentalBasket implements Rental {
	
	private ArrayList<Rental> rentals = new ArrayList<Rental>();
	
	
	public double getPrice() {
		double total = 0;
		for(Rental r:rentals) {
			total += r.getPrice();
		}
		return total;
	}
	public void addRentalItem(Rental i) {
		rentals.add(i);
	}
	public void removeRentalItem(Rental i) {
		rentals.remove(i);
	}
	public int getNumOfRentals() {
		return rentals.size();
	}
	
	public String getTitle() {
		//does not return title since there are multiple movies in a basket
		return null;
	}
	
	public String getRentDays() {
		//does not return rent days since different item may have different rent days
		return null;
	}
	
	public String getMovieType() {
		//does not return movie type since there are multiple movies in a basket
		return null;
	}
}
