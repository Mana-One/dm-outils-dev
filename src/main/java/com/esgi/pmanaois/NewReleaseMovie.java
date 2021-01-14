package com.esgi.pmanaois;

public class NewReleaseMovie extends Movie {
    static private double RENTAL_PRICE_COEFFICIENT = 3.0;

    public NewReleaseMovie( String title ){
        super( title );
    }

    public double calculateRentalPrice( int rentalDays ){
        return rentalDays * RENTAL_PRICE_COEFFICIENT;
    }

    public int calculateRenterPoints( int rentalDays ){
        return rentalDays > 1 ? 2 : DEFAULT_RENTER_POINTS;
    }
}
