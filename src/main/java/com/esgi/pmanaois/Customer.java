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
		return String.format( 
			"%s\t%s\t%s\n", 
			history, 
			movieTitle, 
			String.valueOf( rentalPrice )
		);
	}

	private String appendHistoryBottom( String history, double totalAmount, int rentalPoints ){
		return String.format( 
			"%sYou owed %s\nYou earned %d frequent renter points\n", 
			history,
			String.valueOf( totalAmount ), 
			rentalPoints 
		);
	}
}
