package model;

public class RentalItem implements Rental{
	private Movie movie;
	private int borrowPeriod;
	
	public RentalItem(Movie movie,int days) {
		this.movie = movie;
		this.borrowPeriod = days;
	}
	
	//table view data model
	public double getPrice() {
		return movie.getPrice(borrowPeriod);
	}
	
	public String getTitle() {
		return movie.getTitle();
	}
	
	public String getRentDays() {
		return borrowPeriod + " days";
	}

	@Override
	public String getMovieType() {
		
		return movie.getMovieType();
	}
	
}
