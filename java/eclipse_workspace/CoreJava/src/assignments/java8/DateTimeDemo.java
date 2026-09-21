/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:41:59 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DateTimeDemo {

	public static void main(String[] args) {

		LocalDate today = LocalDate.now();

		System.out.println("Today's Date : " + today);

		Month month = today.getMonth();
		DayOfWeek day = today.getDayOfWeek();

		System.out.println("Month : " + month);
		System.out.println("Day : " + day);

		LocalDate d1 = LocalDate.of(2024, 1, 1);
		LocalDate d2 = LocalDate.of(2024, 12, 31);

		long days = ChronoUnit.DAYS.between(d1, d2);

		System.out.println("Days Between : " + days);

		System.out.println("Leap Year : " + today.isLeapYear());
	}
}
