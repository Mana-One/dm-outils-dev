package com.esgi.pmanaois;

/**
 * Hello world!
 *
 */
public class Launcher {
    public static void main( String[] args ){
        Customer customer = new Customer( "Fred" );
        customer.addRental( new Rental( new ChildrenMovie( "Plan 9 from Outer Space" ), 1 ));
		customer.addRental( new Rental( new ChildrenMovie( "8 1/2" ), 2 ));
		customer.addRental( new Rental( new ChildrenMovie( "Eraserhead" ), 4 ));
        System.out.println( customer.statement() );
    }
}
