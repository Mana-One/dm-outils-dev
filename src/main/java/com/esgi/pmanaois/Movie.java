package com.esgi.pmanaois;

abstract class Movie {	
	protected String title;
	
	public Movie( String title ){
		this.title = title;
	}
	
	public String getTitle(){
		return this.title;
	}	

	abstract double calculateRentalPrice( int rentalDays );
	abstract int calculateRenterPoints( int rentalDays );
}
