package basics;

import java.util.Scanner;

/**
 * Java program to calculate the sum and average of three numbers
 * using Scanner class for user input.
 */
public class SumAverage {

    public static void main(String[] args) {
        
        //Variable Declaration
        int num1, num2, num3, sum;
        float average;
        Scanner scanner = new Scanner(System.in);

        // User Input
        System.out.print("Enter first number: ");
        num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        num2 = scanner.nextInt();
        System.out.print("Enter third number: ");
        num3 = scanner.nextInt();

        System.out.print("Enter ur Name: ");
        String name = scanner.next(); // Note: may need an extra .nextLine() if skipping input

        // Calculating Sum and Average
        sum = num1 + num2 + num3;
        average = sum / 3.0f;

        // Output
        System.out.println("Sum of " + num1 + ", " + num2 + ", and " + num3 + " is: " + sum);
        System.out.println("Average of " + num1 + ", " + num2 + ", and " + num3 + " is: " + average);
        System.out.println("Program created by: " + name);
        
        //Closing the scanner
        scanner.close();
    }
}