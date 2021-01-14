package com.esgi.pmanaois;

public class ChildrenMovie extends Movie {
    static final private double DEFAULT_RENTAL_PRICE = 1.5;
    static final private double RENTAL_PRICE_COEFFICIENT = 1.5;

    public ChildrenMovie( String title ){
        super( title );
    }

    public double calculateRentalPrice( int rentalDays ){
        if( rentalDays <= 3 ){
            return DEFAULT_RENTAL_PRICE;
        }

        return RENTAL_PRICE_COEFFICIENT * ( rentalDays - 3 ) + DEFAULT_RENTAL_PRICE;
    }

    public int calculateRenterPoints( int rentalDays ){
        return DEFAULT_RENTER_POINTS;
    }
}
