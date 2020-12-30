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
	
	public String statement(){
		double totalAmount = 0;
		int	frequentRenterPoints = 0;
		String result = String.format( "Rental Record for %s\n", this.getName() );

		for( Rental rental : this.rentals ){
			double thisAmount = rental.calculateRentalPrice();
			frequentRenterPoints += rental.calculateRenterPoints();
			result = result.concat( String.format( "\t%s\t%s\n", rental.getMovie().getTitle(), String.valueOf( thisAmount ) ));
			totalAmount += thisAmount;
		}
		
		return result.concat( String.format( "You owed %s\n", String.valueOf( totalAmount )))
			.concat( String.format( "You earned %d frequent renter points\n", frequentRenterPoints ));
	}
}
