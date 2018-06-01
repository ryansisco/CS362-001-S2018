/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

	@Test(timeout = 4000) //fills correctly
	public void test00()  throws Throwable  {
		Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		String string0 = appt0.toString();
		assertEquals(2, appt0.getRecurBy());
		assertFalse(appt0.isRecurring());
		assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
		assertEquals(0, appt0.getRecurIncrement());
		appt0.setValid();
	}
	@Test(timeout = 4000) //fills correctly
	public void test01()  throws Throwable  {
		Appt appt0 = new Appt(-15, -30, -9, -14, -2018, "Birthday Party\n", "This is my birthday party", "xyz@gmail.com");
		String string0 = appt0.toString();
		assertEquals(2, appt0.getRecurBy());
		assertFalse(appt0.isRecurring());
		assertEquals(0, appt0.getRecurIncrement());
		appt0.setValid();
		assertEquals(false, appt0.getValid());
	}
	@Test(timeout = 4000) //fills correctly
	public void test02()  throws Throwable {
		Appt appt0 = new Appt(13, 60, 12999, "test", "description", "email");
		assertEquals(2, appt0.getRecurBy());
		assertFalse(appt0.isRecurring());
		appt0.getXmlElement();
		appt0.setStartHour(23);
		appt0.setStartMinute(999999999);
		appt0.setStartDay(2);
		appt0.setStartMonth(3);
		appt0.setStartYear(1000);
		appt0.setTitle("TEST TITLE");
		appt0.setDescription("TEST DESC");
		assertEquals(23, appt0.getStartHour());
		assertEquals(2, appt0.getStartDay());
		assertEquals(999999999, appt0.getStartMinute());
		assertEquals(3, appt0.getStartMonth());
		assertEquals("TEST TITLE", appt0.getTitle());
		assertEquals(true, appt0.hasTimeSet());
	}
	@Test(timeout = 4000) //sets recurrence correctly
	public void test03()  throws Throwable {
		Appt appt0 = new Appt(13, 60, 12999, "test", "description", "email");
		assertEquals(false, appt0.isOn(13, 60, 12999));
		int myArray[] = {0, 2, 4};
		appt0.setRecurrence(myArray, 2, 2, 2);
		assertEquals(2, appt0.getRecurIncrement());
		assertEquals(2, appt0.getRecurBy());
		assertEquals(2, appt0.getRecurNumber());
		assertEquals(myArray, appt0.getRecurDays());
		assertEquals(false, appt0.hasTimeSet());
	}
	@Test(timeout = 4000) //checks if invalid
	public void test04()  throws Throwable {
		Appt appt0 = new Appt(13, 60, 12999, "test", "description", "email");
		appt0.setValid();
		assertEquals(false, appt0.getValid());

		Appt appt1 = new Appt(9999, 9999, -9999, "test", "description", "email");
		appt1.setValid();
		appt1.hasTimeSet();
		assertEquals(false, appt1.getValid());
		assertEquals(true, appt1.hasTimeSet());
	}
}