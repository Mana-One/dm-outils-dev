package com.esgi.pmanaois;

/**
 * Hello world!
 *
 */
public class Launcher {
    public static void main( String[] args ){
        Customer c = new Customer( "Fred" );
        c.addRental( new Rental( new ChildrenMovie( "The Cell" ), 12 ));
        System.out.println( c.statement() );
    }
}
