package com.esgi.pmanaois;

/**
 * Hello world!
 *
 */
public class Launcher {
    public static void main( String[] args ){
        Customer c = new Customer( "Fred" );
        c.addRental( new Rental( new NewReleaseMovie( "The Cell" ), 3 ));
        c.statement();
    }
}
