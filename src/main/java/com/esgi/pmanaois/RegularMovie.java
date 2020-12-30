package com.esgi.pmanaois;

public class RegularMovie extends Movie {
    public RegularMovie( String title ){
        super( title );
    }

    public double calculateRentalPrice( int rentalDays ){
        if( rentalDays <= 2 ){
            return 2.0;
        }

        return 1.5 * ( rentalDays - 2 ) + 2.0;
    }

    public int calculateRenterPoints( int rentalDays ){
        return 1;
    }
}
