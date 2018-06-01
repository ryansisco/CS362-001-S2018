
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
	public void test00()  throws Throwable  { //fine appointment info
		Appt appty = new Appt(999999999,999999999,999999999,999999999,999999999,"test", "tesssst", "test@test.net");
		DataHandler data0 = new DataHandler();
		assertEquals(false, data0.deleteAppt(appty));
		assertEquals(true, data0.save());
		assertEquals(true, data0.saveAppt(appty));
	}
	@Test(timeout = 4000) //bad appointment info
	public void test01()  throws Throwable  {
		Appt appty = new Appt(-999999999,-5,5,9,5,"test", "tesssst", "test@test.net");
		DataHandler data0 = new DataHandler("\"test\n\n\n");
		assertEquals(false, data0.deleteAppt(appty));
		assertEquals(false, data0.save());
		assertEquals(false, data0.saveAppt(appty));
	}
		
	@Test(timeout = 4000) //bad appointment info
	public void test02()  throws Throwable  {
		Appt appty = new Appt(5,-5,5,5,1003,"test", "tesssst", "test@test.net");
		DataHandler data0 = new DataHandler("test\n", false);
		assertEquals(false, data0.deleteAppt(appty));
		assertEquals(false, data0.save());
		assertEquals(false, data0.saveAppt(appty));

	}
}