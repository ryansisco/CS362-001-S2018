package calendar;

import java.util.Calendar;
import java.util.Random;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 5 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
	long startTime = Calendar.getInstance().getTimeInMillis();
   	long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
	/**
	 * Generate Random Tests that tests CalDay Class.
	 */
	
	 @Test 	//addAppt
	 public void randomtest()  throws Throwable  {
	 	System.out.println("Start addAppt() testing");
	 	for (int iteration = 0; elapsed < TestTimeout; iteration++) {
	 		for (int i = 0; i < NUM_TESTS; i++) {
	 			
	 		}
	 		elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if((iteration%10000)==0 && iteration!=0 ) {
				//System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
	 	}
	 	System.out.println("Done addAppt() testing"); 
	 }
}
