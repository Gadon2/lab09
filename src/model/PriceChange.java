package model;

public abstract class PriceChange implements Rental{
	
	protected Rental rental;
	
	
	
	public double getPrice() {
		return 0;
	}
	
	public String getChange() {
		return null;
	}
}
