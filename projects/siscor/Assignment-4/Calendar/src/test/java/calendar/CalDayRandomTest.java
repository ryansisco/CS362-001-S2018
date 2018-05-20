package calendar;

import java.util.Calendar;
import java.util.Random;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=400;
	long startTime = Calendar.getInstance().getTimeInMillis();
   	long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
   	long randomseed =System.currentTimeMillis();
   	Random random = new Random(randomseed);
	/**
	 * Generate Random Tests that tests CalDay Class.
	 */
	
	 @Test 	//addAppt
	 public void randomtest()  throws Throwable  {
	 	System.out.println("Start addAppt() testing");
	 	try {
	 		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
	 			for (int i = 0; i < NUM_TESTS; i++) {
	 				int hour=ValuesGenerator.getRandomIntBetween(random, -10, 30);
	 				int day=ValuesGenerator.getRandomIntBetween(random, -10, 50);
	 				int minute=ValuesGenerator.getRandomIntBetween(random, -10, 70);
	 				int month=ValuesGenerator.getRandomIntBetween(random, -10, 20);
	 				int year=ValuesGenerator.getRandomIntBetween(random, -100, 4000);
	 				String title=(String) ValuesGenerator.getString(random);
	 				String description=(String) ValuesGenerator.getString(random);
	 				String email=(String) ValuesGenerator.getString(random);
	 				Appt appty = new Appt(hour,minute,day,month,year,title, description, email);
	 				CalDay cal = new CalDay();
	 				cal.addAppt(appty);
	 			}
	 			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 ) {
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				}
			}
	 	}catch(NullPointerException e){
			
		}
	 	System.out.println("Done addAppt() testing"); 
	 }
}
