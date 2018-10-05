package model;

public class PublicHolidaySurcharge extends PriceChange{
	public PublicHolidaySurcharge(Rental r) {
		rental = r;
	}
	@Override
	public double getPrice() {
		return 1.1 * rental.getPrice();
	}
	
	@Override
	public String getChange() {
		return "10%";
	}

	@Override
	public String getTitle() {
		return rental.getTitle();
	}
	@Override
	public String getRentDays() {
		return rental.getRentDays();
	}
	@Override
	public String getMovieType() {
		
		return rental.getMovieType();
	}
}
