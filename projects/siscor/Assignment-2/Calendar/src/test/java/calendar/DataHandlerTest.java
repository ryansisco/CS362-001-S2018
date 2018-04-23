
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

	@Test(timeout = 4000)
	public void test00()  throws Throwable  {
		Appt appty = new Appt(5,5,5,5,5,"test", "tesssst", "test@test.net");
		GregorianCalendar first = new GregorianCalendar();
		GregorianCalendar last = new GregorianCalendar();
		getApptOccurences(appty,first, last);
	}
	@Test(timeout = 4000)
	public void test01()  throws Throwable  {

	}

}
