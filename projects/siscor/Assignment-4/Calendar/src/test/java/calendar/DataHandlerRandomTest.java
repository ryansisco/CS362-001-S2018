package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	private static final long TestTimeout = 60 * 5 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
	long startTime = Calendar.getInstance().getTimeInMillis();
   	long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
	/**
	 * Generate Random Tests that tests DataHandler Class.
	 */
	 @Test 	//deleteAppt()
	 public void randomtest()  throws Throwable  {
	 	long randomseed =System.currentTimeMillis(); //10
	 	Random random = new Random(randomseed);
	 	System.out.println("Start deleteAppt() testing");
	 	for (int iteration = 0; elapsed < TestTimeout; iteration++) {
	 		for (int i = 0; i < NUM_TESTS; i++) {
	 			int hour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
	 			int day=ValuesGenerator.getRandomIntBetween(random, 1, 31);
	 			int minute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
	 			int month=ValuesGenerator.getRandomIntBetween(random, 1, 12);
	 			int year=ValuesGenerator.getRandomIntBetween(random, 0, 4000);
	 			String title=(String) ValuesGenerator.getString(random);
	 			String description=(String) ValuesGenerator.getString(random);
	 			String email=(String) ValuesGenerator.getString(random);
	 			Appt appty = new Appt(hour,minute,day,month,year,title, description, email);
				DataHandler appttrue = new DataHandler();
	 			assertEquals(false, appttrue.deleteAppt(appty));
	 		}
	 		elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if((iteration%10000)==0 && iteration!=0 ) {
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
	 	}
	 	System.out.println("Done deleteAppt() testing");
	 }
	 @Test 	//getApptRange()
	 public void randomtest2()  throws Throwable  {
	 	long randomseed =System.currentTimeMillis(); //10
	 	Random random = new Random(randomseed);
	 	System.out.println("Start getApptRange() testing");
	 	for (int iteration = 0; elapsed < TestTimeout; iteration++) {
	 		for (int i = 0; i < NUM_TESTS; i++) {
	 			int hour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
	 			int hour2=ValuesGenerator.getRandomIntBetween(random, 0, 23);
	 			int day=ValuesGenerator.getRandomIntBetween(random, 1, 31);
	 			int day2=ValuesGenerator.getRandomIntBetween(random, 1, 31);
	 			int minute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
	 			int minute2=ValuesGenerator.getRandomIntBetween(random, 0, 59);
	 			int month=ValuesGenerator.getRandomIntBetween(random, 1, 12);
	 			int month2=ValuesGenerator.getRandomIntBetween(random, 1, 12);
	 			int year=ValuesGenerator.getRandomIntBetween(random, 0, 4000);
	 			int year2=ValuesGenerator.getRandomIntBetween(random, 0, 4000);
	 			GregorianCalendar firstDay = new GregorianCalendar(year, month, day, hour, minute);
				GregorianCalendar lastDay = new GregorianCalendar(year2, month2, day2, hour2, minute2);
	 			DataHandler appttrue = new DataHandler();
	 			if (firstDay.before(lastDay)) {
	 				appttrue.getApptRange(firstDay, lastDay);
	 			}
	 		}
	 		elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if((iteration%10000)==0 && iteration!=0 ) {
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
	 	}
	 	System.out.println("Done getApptRange() testing");
	 }



}
