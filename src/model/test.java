package model;

public class test {

	public static void main(String[] args) {
		
		New newType = new New();
		Regular regular = new Regular();
		Classic classic = new Classic();
		
		Movie m1 = new Movie("HaliPotah",newType);
		Movie m2 = new Movie("CloudDragon Lee",classic);
		Movie m3 = new Movie("Happy yida's Life",regular);
		
		RentalItem rent1 = new RentalItem(m1,2);
		RentalItem rent2 = new RentalItem(m2,5);
		RentalItem rent3 = new RentalItem(m3,7);
		RentalItem rent4 = new RentalItem(m3,3);
		
		
		RentalBasket rb1 = new RentalBasket();
		rb1.addRentalItem(rent1);
		rb1.addRentalItem(rent2);
		rb1.addRentalItem(rent3);
		rb1.addRentalItem(rent4);
		
		SchoolHolidayDiscount sd = new SchoolHolidayDiscount(rb1);
		OverallDiscount od = new OverallDiscount(sd);
		
		System.out.println("Single item price: " + rent4.getPrice());
		System.out.println("Basket price: "+ rb1.getPrice());
		System.out.println("discount price: "+ od.getPrice());
	}

}
