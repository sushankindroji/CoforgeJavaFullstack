/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :1:00:26 pm
 * Email : saisushankindroji1476@gmail.com
 */


package exceptionsdemo;

public class Multiplecatchdemo2 {

	public static void main(String[] args) {

		int availableTickets = 5;
		int requestedTickets = 0;
		//String userInput = "abc"; // Simulating user input that is not a number
		//String userInput = "10"; 
		String userInput = "3"; 
		try {
			// Simulating user input for requested tickets
			requestedTickets = Integer.parseInt(userInput);

			if (requestedTickets <= 0) {
				throw new IllegalArgumentException("Requested tickets must be greater than zero.");
			}

			if (requestedTickets > availableTickets) {
				throw new ArithmeticException("Not enough tickets available.");
			}

			System.out.println("Booking successful! Tickets booked: " + requestedTickets);
		} catch (NumberFormatException e) {
			System.err.println("Invalid input! Please enter a valid number of tickets.");
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println("Thank you for using the Movie Ticket Booking System.");
		}

	}

}
