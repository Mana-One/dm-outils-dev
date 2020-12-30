package com.esgi.pmanaois;
import java.util.List;
import java.util.ArrayList;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer( String name ){
		this.name = name;
	}
	
	public void addRental( Rental rental ){
		this.rentals.add( rental );
	}
	
	public String getName(){
		return this.name;
	}
	
	public String statement () {
		double totalAmount = 0;
		int	frequentRenterPoints = 0;
		String result = "Rental Record for " + getName () + "\n";

		for( Rental rental : rentals ){
			double thisAmount = 0;

			thisAmount += rental.getMovie().calculateRentalPrice( rental.getDaysRented() );
			frequentRenterPoints += rental.getMovie().calculateRenterPoints( rental.getDaysRented() );
			result += "\t" + rental.getMovie().getTitle() + "\t"
								+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		
		result += "You owed " + String.valueOf( totalAmount ) + "\n";
		result += "You earned " + String.valueOf( frequentRenterPoints ) + " frequent renter points\n";
		
		
		return result;
	}
}
