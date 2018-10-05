package model;


import javafx.beans.property.SimpleStringProperty;

public class Movie {

	
	private String title;
	private MovieType type;
	
	
	public Movie(String title,MovieType type) {
		this.title = title;
		this.type = type;
		
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getMovieType () {
		return type.getType();
	}

	public double getNormalPrice() {
		return type.getNormalPrice();
	}

	public double getPrice(int day) {
		return type.getPrice(day);
	}
	

	
}