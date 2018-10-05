package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.*;

public class RentController {


    private Stage currStage;
    //initialize rent basket
	private RentalBasket rentBasket = new RentalBasket();
	
	//for testing
	//if today is public holiday or school holiday
	private boolean ifPublicHoliday = false;
	private boolean ifSchoolHoliday = false;
	
    //labels 
    @FXML
    private Label totalPrice;
    
    @FXML
    private Label publicHolidayInfo;
    
    @FXML
    private Label schoolHolidayInfo;
    
    @FXML
    private Label overallDiscountInfo;
    
    //buttons
    @FXML
    private Button getPriceBtn;
    
    @FXML
    private Button addToBtn;
    
    @FXML
    private Button removeBtn;
    
    //textfields
    @FXML
    private TextField rentDays;
    
    //two panes
    @FXML
    private TableView<Movie> movieList;
    
    @FXML
    private TableView<Rental> rentCart;
    //two checkbox
    @FXML
    private CheckBox publicHolidayBox;
    
    @FXML
    private CheckBox schoolHolidayBox;
    
    public RentController(Stage s) {
        currStage = s;
    }

    @FXML
    public void initialize() {
    	totalPrice.setText("0.0");
    	//initialize movie list
    	New newType = new New();
		Regular regular = new Regular();
		Classic classic = new Classic();
		
		Movie m1 = new Movie("Book club",newType);
		Movie m2 = new Movie("The meg",classic);
		Movie m3 = new Movie("Jurassic World I",classic);
		Movie m4 = new Movie("Jurassic World VI",newType);
		Movie m5 = new Movie("Gone with the wind",regular);
		
		ObservableList<Movie> moviedata = movieList.getItems();
    	moviedata.add(m1);
    	moviedata.add(m2);
    	moviedata.add(m3);
    	moviedata.add(m4);
    	moviedata.add(m5);
    			
    	
    	
    	
    }
    
    
    @FXML
    public void handleGetPriceBtn() {
    	String overallDiscountmsg = "You got 10% overall discount for more than 4 movies in one transaction";
    	if (rentBasket.getNumOfRentals() > 4) {
    		Rental rental = new OverallDiscount(rentBasket);
    		
    		//cut decimals
    		String total = String.valueOf(rental.getPrice());
    		int maxLength = (total.length() < 5)?total.length():5;
    		total = total.substring(0, maxLength);
    		totalPrice.setText(total);	
    		
    		overallDiscountInfo.setText(overallDiscountmsg);
    		
    	} else {
    		Rental rental = rentBasket;
    		totalPrice.setText(String.valueOf(rental.getPrice()));
    		overallDiscountInfo.setText("");
    	}
    	
    }
    //remove from cart
    @FXML
    public void handleRemoveBtn() {
    	Rental removedItem = rentCart.getSelectionModel().getSelectedItem();
    	ObservableList<Rental> cart = rentCart.getItems();
    	cart.remove(removedItem);
    	rentBasket.removeRentalItem(removedItem);
    }
    //add to cart
    @FXML
    public void handleAddToBtn() {
    	//if the textbox is not empty
    	if(rentDays.getText().length() != 0) {
    		int days = Integer.parseInt(rentDays.getText());
    		Movie addedMovie = movieList.getSelectionModel().getSelectedItem();
        	Rental rental = new RentalItem(addedMovie,days);
        	//public holiday surcharge
        	if(ifPublicHoliday) rental = new PublicHolidaySurcharge(rental);
        	//school holiday discount
        	if(ifSchoolHoliday) rental = new SchoolHolidayDiscount(rental);
        	ObservableList<Rental> cart = rentCart.getItems();
        	cart.add(rental);
        	rentBasket.addRentalItem(rental);
    	}
    	
    }
    
    //handle checkboxes
    @FXML
    public void handlePublicHolidayBox() {
    	String publicHolidaymsg = "Today is public holiday, all movies will have an 10% additional surcharge!";
    	
    	if (publicHolidayBox.isSelected()) {
    		ifPublicHoliday = true;
    		publicHolidayInfo.setText(publicHolidaymsg);
    	} else {
    		ifPublicHoliday = false;
    		publicHolidayInfo.setText("");
    	}
    }
    
    @FXML
    public void handleSchoolHolidayBox() {
    	String schoolHolidaymsg = "Today is school holiday, all regular and classic movies will receive 25% discount!";
    	if (schoolHolidayBox.isSelected()) {
    		ifSchoolHoliday = true;
    		schoolHolidayInfo.setText(schoolHolidaymsg);
    	} else {
    		ifSchoolHoliday = false;
    		schoolHolidayInfo.setText("");
    	}
    }


}
