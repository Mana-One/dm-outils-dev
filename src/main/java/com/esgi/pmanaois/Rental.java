package com.esgi.pmanaois;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental( Movie movie, int daysRented ){
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
	public int getDaysRented(){
		return this.daysRented;
	}
	
	public String getMovieTitle(){
		return this.movie.getTitle();
	}

	public double calculateRentalPrice(){
		return this.movie.calculateRentalPrice( this.daysRented );
	}

	public int calculateRenterPoints(){
		return this.movie.calculateRenterPoints( this.daysRented );
	}
}
