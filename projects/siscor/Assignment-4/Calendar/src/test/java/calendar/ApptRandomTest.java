package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=400;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name 
	}
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
	public static int RandomSelectRecur(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return the value of the  appointments to recur 
	}	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
	public static int RandomSelectRecurForEverNever(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return appointments to recur forever or Never recur 
	}	
   /**
	 * Generate Random Tests that tests Appt Class.
	 */
   long startTime = Calendar.getInstance().getTimeInMillis();
   long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
   long randomseed =System.currentTimeMillis();
   Random random = new Random(randomseed);
   @Test
   public void randomtest()  throws Throwable  {
   	System.out.println("Start initial testing...");

   	try{ 
   		for (int iteration = 0; elapsed < TestTimeout; iteration++) {

   			int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
   			int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
   			int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
   			int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
   			int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
   			String title="Birthday Party";
   			String description="This is my birthday party.";
   			String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data	 
				 //Construct a new Appointment object with the initial data	 
   			Appt appt = new Appt(startHour,
   				startMinute ,
   				startDay ,
   				startMonth ,
   				startYear ,
   				title,
   				description,
   				emailAddress);

   			if(!appt.getValid())continue;
   			for (int i = 0; i < NUM_TESTS; i++) {
   				String methodName = ApptRandomTest.RandomSelectMethod(random);
   				if (methodName.equals("setTitle")){
   					String newTitle=(String) ValuesGenerator.getString(random);
   					appt.setTitle(newTitle);						   
   				}
   				else if (methodName.equals("setRecurrence")){
   					int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
   					int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
   					int recur=ApptRandomTest.RandomSelectRecur(random);
   					int recurIncrement = ValuesGenerator.RandInt(random);
   					int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
   					appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
   				}				
   			}

   			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
   			if((iteration%10000)==0 && iteration!=0 )
   				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

   		}
   	}catch(NullPointerException e){

   	}
   	System.out.println("Done initial testing...");
   }
	 @Test 	//setValid()
	 public void randomtest2()  throws Throwable  {
	 	System.out.println("Start setValid() testing");
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
	 				appty.setValid();
	 			}
	 			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
	 			if((iteration%10000)==0 && iteration!=0 ) {
	 				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
	 			}
	 		}
	 	}catch(NullPointerException e){

	 	}
	 	System.out.println("Done setValid() testing");
	 	}
	 @Test 	//setRecurDays()
	 public void randomtest3()  throws Throwable  {
	 	System.out.println("Start setRecurDays() testing");
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
	 			int arraysize = ValuesGenerator.getRandomIntBetween(random, 0, 10);
	 			int[] recurDays = new int[arraysize];
	 			for (int j = 0; j < arraysize; j++) {
	 				recurDays[j]=ValuesGenerator.getRandomIntBetween(random, 0, 10);
	 			}
	 			int recurBy=ValuesGenerator.getRandomIntBetween(random, 0, 100);
	 			int recurIncrement=ValuesGenerator.getRandomIntBetween(random, 0, 100);
	 			int recurNumber=ValuesGenerator.getRandomIntBetween(random, 0, 100);
	 			Appt appty = new Appt(hour,minute,day,month,year,title, description, email);
	 			if (i == 0) {
	 				appty.setRecurrence(null, recurBy, recurIncrement, recurNumber);
	 			}
	 			appty.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
	 		}
	 		elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
	 		if((iteration%10000)==0 && iteration!=0 ) {
	 			System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
	 		}
	 	}
	 	System.out.println("Done setRecurDays() testing");
	 }
	 @Test 	//isOn()
	 public void randomtest4()  throws Throwable  {
	 	System.out.println("Start isOn() testing");
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
	 			assertEquals(true, appty.isOn(day, month, year));
	 			assertEquals(false, appty.isOn(day, month, year+1));
	 			assertEquals(false, appty.isOn(day, month+1, year));
	 			assertEquals(false, appty.isOn(day+1, month, year));
	 		}
	 		elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
	 		if((iteration%10000)==0 && iteration!=0 ) {
	 			System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
	 		}
	 	}
	 	System.out.println("Done isOn() testing");
	 }
	}	
