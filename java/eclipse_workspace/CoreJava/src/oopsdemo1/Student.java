package oopsdemo1;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :4:20:20 pm
 * Email : saisushankindroji1476@gmail.com
 */

//Instance class - Encapsulation

import java.util.Scanner;

public class Student {

	//define properties/state/attributes
	private int rollNumber;
	private String firstName, lastName;
	private float[] marks = new float[5];
	private float total;

	Scanner scanner = new Scanner(System.in);

	//define methods/behavior/actions
    public void inputStudentDetails() {
        System.out.println("Enter Roll Number of a Student :");
        rollNumber=scanner.nextInt();
        System.out.println("Enter First Name & Last Name of a Student :");
        firstName=scanner.next();
        lastName=scanner.next();

        System.out.println("Enter Marks of 5 Subjects :");
        for (int i = 0; i < marks.length; i++) {
            marks[i]=scanner.nextFloat();
        }
    }

    //Method with float as return type
    public float calculateTotalMarks() {
        for (int i = 0; i < marks.length; i++) {
            total+=marks[i];
        }
        return total;
    }

    public void displayStudentDetails() {
    	System.out.println("************* Student Result Information ***************");
		System.out.println("Roll Number                : "+rollNumber);
		System.out.println("Student Name               : "+firstName+" "+lastName);
		System.out.println("Total Marks                : "+total);
		System.out.println("********************************************************");
	}
}
