package model;


//if a customer borrows more than 4 videos of any type in 
//one transaction, apply 10% overall discount
public class OverallDiscount extends PriceChange{

	public OverallDiscount(Rental r) {
		rental = r;
	}
	@Override
	public double getPrice() {
		return 0.9 * rental.getPrice();
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
