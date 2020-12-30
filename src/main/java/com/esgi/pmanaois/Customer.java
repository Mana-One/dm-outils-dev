package com.esgi.pmanaois;
import java.util.Vector;
import java.util.Enumeration;

public class Customer {
	private String name;
	private Vector<Rental> rentals = new Vector<Rental>();

	public Customer (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.addElement( rental );
	}
	
	public String getName(){
		return this.name;
	}
	
	public String statement () {
		double totalAmount = 0;
		int	frequentRenterPoints = 0;
		Enumeration<Rental> rentals = this.rentals.elements ();
		String result = "Rental Record for " + getName () + "\n";
		
		while (rentals.hasMoreElements ()) {
			double thisAmount = 0;
			Rental each = (Rental)rentals.nextElement ();
			
			// determines the amount for each line
			thisAmount += each.getMovie().calculateRentalPrice( each.getDaysRented() );
			
			frequentRenterPoints += each.getMovie().calculateRenterPoints( each.getDaysRented() );
				
			result += "\t" + each.getMovie().getTitle() + "\t"
								+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
				
		}
		
		result += "You owed " + String.valueOf( totalAmount ) + "\n";
		result += "You earned " + String.valueOf( frequentRenterPoints ) + " frequent renter points\n";
		
		
		return result;
	}
}
