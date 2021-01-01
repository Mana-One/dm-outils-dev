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
	
	public String getRentalHistory(){
		double totalAmount = 0;
		int	frequentRenterPoints = 0;
		String history = this.getHistoryTop();

		for( Rental rental : this.rentals ){
			double rentalPrice = rental.calculateRentalPrice();
			frequentRenterPoints += rental.calculateRenterPoints();
			history = this.appendHistoryBody( history, rental.getMovieTitle(), rentalPrice );
			totalAmount += rentalPrice;
		}
		
		return this.appendHistoryBottom( history, totalAmount, frequentRenterPoints );
	}

	private String getHistoryTop(){
		return String.format( "Rental Record for %s\n", this.name );
	}

	private String appendHistoryBody( String history, String movieTitle, double rentalPrice ){
		return history.concat( String.format( "\t%s\t%s\n", movieTitle, String.valueOf( rentalPrice )));
	}

	private String appendHistoryBottom( String history, double totalAmount, int rentalPoints ){
		return history
			.concat( String.format( "You owed %s\n", String.valueOf( totalAmount )))
			.concat( String.format( "You earned %d frequent renter points\n", rentalPoints ));
	}
}
