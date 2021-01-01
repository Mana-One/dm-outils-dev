import com.esgi.pmanaois.*;

import org.junit.Test;

import junit.framework.TestCase;

public class VideoStoreTest extends TestCase {
	private Customer customer;

	public VideoStoreTest( String name ){
		super( name );
	}
	
	protected void setUp(){
		this.customer = new Customer( "Fred" );
	}

	@Test
	public void testNoRentalRentalHistory(){
		assertEquals( "Rental Record for Fred\n"
			.concat( "You owed 0.0\n" )
			.concat( "You earned 0 frequent renter points\n" ), 
		customer.getRentalHistory() );
	}
	
	@Test
	public void testSingleNewReleaseRentalHistory(){
		customer.addRental( new Rental( new NewReleaseMovie( "The Cell" ), 3 ));	
			
		assertEquals( "Rental Record for Fred\n"
			.concat( "\tThe Cell\t9.0\n" )
			.concat( "You owed 9.0\n" )
			.concat( "You earned 2 frequent renter points\n" ), 
		customer.getRentalHistory() );
	}

	@Test
	public void testSingleNewReleaseOneDayRentalHistory(){
		customer.addRental( new Rental( new NewReleaseMovie( "The Cell" ), 1 ));		

		assertEquals( "Rental Record for Fred\n"
			.concat( "\tThe Cell\t3.0\n" )
			.concat( "You owed 3.0\n" )
			.concat( "You earned 1 frequent renter points\n" ), 
		customer.getRentalHistory() );
	}

	@Test
	public void testSingleChildrensRentalHistory(){
		customer.addRental( new Rental( new ChildrenMovie( "The Tigger Movie" ), 3 ));

		assertEquals( "Rental Record for Fred\n"
			.concat( "\tThe Tigger Movie\t1.5\n" )
			.concat( "You owed 1.5\n" )
			.concat( "You earned 1 frequent renter points\n" ), 
		customer.getRentalHistory() );
	}

	@Test
	public void testSingleChildrensMoreThanThreeDaysRentalHistory(){
		customer.addRental( new Rental( new ChildrenMovie( "The Tigger Movie" ), 12 ));

		assertEquals( "Rental Record for Fred\n"
			.concat( "\tThe Tigger Movie\t15.0\n" )
			.concat( "You owed 15.0\n" )
			.concat( "You earned 1 frequent renter points\n" ), 
		customer.getRentalHistory() );
	}

	@Test
	public void testSingleRegularRentalHistory(){
		customer.addRental( new Rental( new RegularMovie( "Gran Torino" ), 2 ));

		assertEquals( "Rental Record for Fred\n"
			.concat( "\tGran Torino\t2.0\n" )
			.concat( "You owed 2.0\n" )
			.concat( "You earned 1 frequent renter points\n" ), 
		customer.getRentalHistory() );
	}

	@Test
	public void testSingleRegularMoreThanTwoDaysRentalHistory(){
		customer.addRental( new Rental( new RegularMovie( "Gran Torino" ), 6 ));

		assertEquals( "Rental Record for Fred\n"
			.concat( "\tGran Torino\t8.0\n" )
			.concat( "You owed 8.0\n" )
			.concat( "You earned 1 frequent renter points\n" ), 
		customer.getRentalHistory() );
	}

	@Test
	public void testDualNewReleaseRentalHistory(){
		customer.addRental( new Rental( new NewReleaseMovie( "The Cell" ), 3 ));
		customer.addRental( new Rental( new NewReleaseMovie( "The Tigger Movie" ), 3 ));	

		assertEquals( "Rental Record for Fred\n"
			.concat( "\tThe Cell\t9.0\n" )
			.concat( "\tThe Tigger Movie\t9.0\n" )
			.concat( "You owed 18.0\n" )
			.concat( "You earned 4 frequent renter points\n" ), 
		customer.getRentalHistory() );
	}

	@Test
	public void testMultipleChildrenRentalHistory(){
		customer.addRental( new Rental( new ChildrenMovie( "Plan 9 from Outer Space" ), 1 ));
		customer.addRental( new Rental( new ChildrenMovie( "8 1/2" ), 2 ));
		customer.addRental( new Rental( new ChildrenMovie( "Eraserhead" ), 3 ));

		assertEquals( "Rental Record for Fred\n"
			.concat( "\tPlan 9 from Outer Space\t1.5\n" ) 
			.concat( "\t8 1/2\t1.5\n" )
			.concat( "\tEraserhead\t1.5\n" ) 
			.concat( "You owed 4.5\n" )
			.concat( "You earned 3 frequent renter points\n" ), 
		customer.getRentalHistory() );
	}
	
	@Test
	public void testMultipleRegularRentalHistory(){
		customer.addRental( new Rental( new RegularMovie( "Plan 9 from Outer Space" ), 1 ));
		customer.addRental( new Rental( new RegularMovie( "8 1/2" ), 2 ));
		customer.addRental( new Rental( new RegularMovie( "Eraserhead" ), 3 ));
		
		assertEquals( "Rental Record for Fred\n"
			.concat( "\tPlan 9 from Outer Space\t2.0\n" ) 
			.concat( "\t8 1/2\t2.0\n" )
			.concat( "\tEraserhead\t3.5\n" ) 
			.concat( "You owed 7.5\n" )
			.concat( "You earned 3 frequent renter points\n" ), 
		customer.getRentalHistory() );
	}

	@Test
	public void testMultipleMoviesRentalHistory(){
		customer.addRental( new Rental( new NewReleaseMovie( "Plan 9 from Outer Space" ), 1 ));
		customer.addRental( new Rental( new ChildrenMovie( "8 1/2" ), 2 ));
		customer.addRental( new Rental( new RegularMovie( "Eraserhead" ), 3 ));
		
		assertEquals( "Rental Record for Fred\n"
			.concat( "\tPlan 9 from Outer Space\t3.0\n" ) 
			.concat( "\t8 1/2\t1.5\n" )
			.concat( "\tEraserhead\t3.5\n" ) 
			.concat( "You owed 8.0\n" )
			.concat( "You earned 3 frequent renter points\n" ), 
		customer.getRentalHistory() );
	}
}
