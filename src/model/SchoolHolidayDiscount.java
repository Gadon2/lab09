package model;

public class SchoolHolidayDiscount extends PriceChange{
	public SchoolHolidayDiscount(Rental r) {
		rental = r;
	}
	
	
	//rental should be regular or classic movie
	@Override
	public double getPrice() {
		
		String type = getMovieType();
		if(!type.equals("new")) {
			return 0.75 * rental.getPrice();
		}
		
		return rental.getPrice();
	}
	
	@Override
	public String getChange() {
		return "25%";
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
