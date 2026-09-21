package basics;

public class Arithmetic {
	public static void main(String[] args) {

	    // Variable Declaration and Initialization
	    int a = 20, b = 10;

	    // Addition
	    int sum = a + b;
	    System.out.println("Sum of " + a + " and " + b + " is: " + sum);

	    // Subtraction
	    int difference = a - b;
	    System.out.println("Difference of " + a + " and " + b + " is: " + difference);

	    // Multiplication
	    int product = a * b;
	    System.out.println("Product of " + a + " and " + b + " is: " + product);

	    // Division
	    if (b != 0) {
	        int quotient = a / b;
	        System.out.println("Quotient of " + a + " and " + b + " is: " + quotient);
	    } else {
	        System.out.println("Division by zero is not allowed.");
	    }
	}
}
