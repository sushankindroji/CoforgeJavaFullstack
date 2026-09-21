/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :10:02:52 am
 * Email : saisushankindroji1476@gmail.com
 */

package miscellaneous;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateFunctionDemo {

    public static void main(String[] args) {

        Date currentDate = new Date();

        System.out.println("Current Date : " + currentDate);

        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        System.out.println("Formatted Date : "
                + dateFormat.format(currentDate));

        Calendar calendar = Calendar.getInstance();

        // Add 10 days

        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 10);

        System.out.println("Date after 10 days : "
                + dateFormat.format(calendar.getTime()));

        // Subtract 5 days

        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, -5);

        System.out.println("Date 5 days ago : "
                + dateFormat.format(calendar.getTime()));

        // Specific Date

        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 25);

        Date specificDate = calendar.getTime();

        System.out.println("Specific Date : "
                + dateFormat.format(specificDate));

        System.out.println("Year : " + calendar.get(Calendar.YEAR));
        System.out.println("Month : "
                + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("Day : "
                + calendar.get(Calendar.DAY_OF_MONTH));

        if (specificDate.before(currentDate)) {

            System.out.println("Specific date is before current date.");

        } else if (specificDate.after(currentDate)) {

            System.out.println("Specific date is after current date.");

        } else {

            System.out.println("Both dates are same.");
        }

        System.out.println("-------------------------------------");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter DOB (dd/MM/yyyy): ");

        String dobInput = scanner.nextLine();

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd/MM/yyyy");

        Date dob;

        try {

            dob = sdf.parse(dobInput);

        } catch (ParseException e) {

            System.out.println("Invalid Date Format");

            scanner.close();
            return;
        }

        Calendar current = Calendar.getInstance();

        Calendar birth = Calendar.getInstance();

        birth.setTime(dob);

        int years =
                current.get(Calendar.YEAR)
                        - birth.get(Calendar.YEAR);

        int months =
                current.get(Calendar.MONTH)
                        - birth.get(Calendar.MONTH);

        int days =
                current.get(Calendar.DAY_OF_MONTH)
                        - birth.get(Calendar.DAY_OF_MONTH);

        if (days < 0) {

            months--;

            Calendar temp = (Calendar) current.clone();

            temp.add(Calendar.MONTH, -1);

            days += temp.getActualMaximum(Calendar.DAY_OF_MONTH);
        }

        if (months < 0) {

            years--;

            months += 12;
        }

        System.out.println("Age : "
                + years + " Years "
                + months + " Months "
                + days + " Days");

        scanner.close();
    }
}