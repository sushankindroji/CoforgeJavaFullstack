/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :12:46:48 pm
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

import java.util.Calendar;
import java.util.Date;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {

	public static void main(String[] args) {

		// Legacy Date class (Deprecated methods)
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getDate());
		System.out.println(d1.getHours() + " : " + d1.getMinutes() + " : " + d1.getSeconds());

		// Calendar Class
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());

		System.out.println("********** Java 8 Date & Time Classes ************");

		LocalDate d = LocalDate.now();
		LocalTime t = LocalTime.now();
		LocalDateTime dt = LocalDateTime.now();

		System.out.println("Date & Time is : " + d + " --> " + t);
		System.out.println("Before Formatting : " + dt);

		LocalDateTime dt2 = dt.minusDays(100);
		System.out.println("100 Days Before : " + dt2);

		LocalDateTime dt3 = dt.plusDays(50);
		System.out.println("50 Days After : " + dt3);

		DateTimeFormatter format =
				DateTimeFormatter.ofPattern("EEEE dd-MMM-yyyy HH:mm:ss");
		String dt1 = dt.format(format);
		System.out.println("After Formatting : " + dt1);

		DateTimeFormatter format1 =
				DateTimeFormatter.ofPattern("EEE dd-MMMM-yyyy HH:mm:ss");
		String dt5 = dt.format(format1);
		System.out.println("After Formatting : " + dt5);

		// Clock class
		Clock c1 = Clock.systemDefaultZone();
		System.out.println("System Zone : " + c1.getZone());

		// Japan Time
		ZoneId z1 = ZoneId.of("Asia/Tokyo");
		LocalTime t1 = LocalTime.now(z1);
		System.out.println("Japan Time : " + t1);

		// Germany Time
		ZoneId z3 = ZoneId.of("Europe/Berlin");
		LocalTime t3 = LocalTime.now(z3);
		System.out.println("Germany Time : " + t3);

		// Zoned Date Time
		ZonedDateTime z2 = ZonedDateTime.now();
		System.out.println(z2.getZone() + " " + z2.getDayOfWeek());
		System.out.println(z2);
	}
}