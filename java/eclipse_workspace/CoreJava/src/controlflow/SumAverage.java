package controlflow;

import java.util.Scanner;

/**
 * Java program to find sum and average of 3 numbers which are greater than 100 
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

        if ((num1 > 100) && (num2 > 100) && (num3 > 100)) {
            
            // Perform Calculations
            sum = num1 + num2 + num3;
            float avg = (float) sum / 3;    // TypeCasting
            
            System.out.println("The Sum of 3 Numbers is : " + sum);
            System.out.println("The Average of 3 Numbers is : " + avg);
            System.out.println("The Average of 3 Numbers is : " + String.format("%.2f", avg));
            
        } else {
            System.out.println("Please Enter Numbers Greater then 100");
        }

        
        //Closing the scanner
        scanner.close();
    }
}