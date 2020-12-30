package com.esgi.pmanaois;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie( String title ){
        super( title );
    }

    public double calculateRentalPrice( int rentalDays ){
        return rentalDays * 3.0;
    }

    public int calculateRenterPoints( int rentalDays ){
        return rentalDays > 1 ? 2 : 1;
    }
}
