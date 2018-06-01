/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;


public class CalDayTest{

	@Test(timeout = 4000) //incorrect appdata works
	public void test00()  throws Throwable  {
		Appt appty = new Appt(5,5,5,5,5,"test", "te\n\n\nsssst", "test@test.net\n");
		CalDay day0 = new CalDay();
		day0.toString();
		//day0.addAppt(appty);
		day0.getDay();
		day0.getMonth();
		day0.getYear();
		day0.iterator();
	}
	@Test(timeout = 4000) // constrct works
	public void test01()  throws Throwable  {
		CalDay day0 = new CalDay();
		day0.toString();
		day0.getAppts();
		day0.getDay();
		day0.getMonth();
		day0.getYear();
	}
	@Test(timeout = 4000) //fills correctly w/ bad data
	public void test02()  throws Throwable  {
		GregorianCalendar calendar = new GregorianCalendar(999999999, -80, -60);
		CalDay day0 = new CalDay(calendar);
		assertEquals(0, day0.toString());
		assertEquals(1, day0.getAppts());
		assertEquals(-60, day0.getDay());
		assertEquals(-80, day0.getMonth());
		assertEquals(999999999, day0.getYear());
		assertEquals(1, day0.iterator());
		day0.getFullInfomrationApp(day0);
	}
	@Test(timeout = 4000) //no apps added
	public void test03()  throws Throwable  {
		GregorianCalendar calendar = new GregorianCalendar(999999999, -80, -60);
		CalDay day0 = new CalDay(calendar);
		assertEquals(0, day0.getSizeAppts());
	}
	@Test(timeout = 4000)
	public void test04()  throws Throwable  { //fill information
		Appt appty = new Appt(14,40,3,4,2018,"test", "tensssst", "test@test.net");
		GregorianCalendar calendar = new GregorianCalendar(2018, 4, 3, 14, 40, 34);
		CalDay day0 = new CalDay(calendar);
		day0.getFullInfomrationApp(day0);
	}
}