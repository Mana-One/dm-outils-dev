package com.esgi.pmanaois;

public class ChildrenMovie extends Movie {
    public ChildrenMovie( String title ){
        super( title );
    }

    public double calculateRentalPrice( int rentalDays ){
        if( rentalDays <= 3 ){
            return 1.5;
        }

        return 1.5 * ( rentalDays - 3 ) + 1.5;
    }

    public int calculateRenterPoints( int rentalDays ){
        return 1;
    }
}
