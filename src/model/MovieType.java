package model;

public abstract class MovieType {
	
	//type
	protected String name;
	//borrowing period
	protected int period;
	//normal charge
	protected double normalC;
	//additional daily charge
	protected double additionalC;
	
	

	
	public double getPrice(int days) {
		double price;
		if(days > period) {
			price = normalC + (additionalC + normalC / period)*(days - period);
		} else {
			price = normalC;
		}
        return price;
	}
	
	public String getType() {
		return this.name;
	}
	
	public double getNormalPrice() {
		return this.normalC;
	}
}