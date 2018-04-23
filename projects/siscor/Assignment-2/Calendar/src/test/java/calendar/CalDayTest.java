/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;


import java.util.GregorianCalendar;
import java.util.LinkedList;

public class CalDayTest{

	@Test(timeout = 4000)
	public void test00()  throws Throwable  {
		GregorianCalendar calendar = new GregorianCalendar();
		Appt appty = new Appt(5,5,5,5,5,"test", "tesssst", "test@test.net");
		CalDay day0 = new CalDay();
		day0.toString();
		// day0.addAppt(appty);
		day0.getDay();
		day0.getMonth();
		day0.getYear();
		day0.iterator();
	}
	@Test(timeout = 4000)
	public void test01()  throws Throwable  {
		GregorianCalendar calendar = new GregorianCalendar(-1300, -80, -60);
		CalDay day0 = new CalDay();
		day0.toString();
		day0.getAppts();
		day0.getDay();
		day0.getMonth();
		day0.getYear();
	}
}
