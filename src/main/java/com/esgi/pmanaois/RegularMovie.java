package com.esgi.pmanaois;

public class RegularMovie extends Movie {
    static final private double DEFAULT_RENTAL_PRICE = 2.0;
    static final private double RENTAL_PRICE_COEFFICIENT = 1.5;

    public RegularMovie( String title ){
        super( title );
    }

    public double calculateRentalPrice( int rentalDays ){
        if( rentalDays <= 2 ){
            return DEFAULT_RENTAL_PRICE;
        }

        return RENTAL_PRICE_COEFFICIENT * ( rentalDays - 2 ) + DEFAULT_RENTAL_PRICE;
    }

    public int calculateRenterPoints( int rentalDays ){
        return DEFAULT_RENTER_POINTS;
    }
}
