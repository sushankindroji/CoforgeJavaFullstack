package controlflow;

import java.util.Scanner;

/**
 * Author : sushank2
 * Date : 04-Jul-2026
 * Java Program to demonstrate the Student Result Management System
 */
public class StudentResult {

    public static void main(String[] args) {

        // Declarations
        int rollNumber;
        String firstName, grade;
        float marks1, marks2, marks3, marks4, marks5, total, percentage;

        Scanner scan = new Scanner(System.in);

        // Input
        System.out.println("Enter Roll Number :");
        rollNumber = scan.nextInt();

        System.out.println("Enter Student Name :");
        firstName = scan.next();

        System.out.println("Enter Marks of 5 Subjects :");
        marks1 = scan.nextFloat();
        marks2 = scan.nextFloat();
        marks3 = scan.nextFloat();
        marks4 = scan.nextFloat();
        marks5 = scan.nextFloat();

        // Calculate Total and Percentage
        total = marks1 + marks2 + marks3 + marks4 + marks5;
        percentage = (total / 500) * 100;

        // Grade Calculation
        if (percentage >= 85) {
            grade = "Distinction";
        } else if (percentage >= 60) {
            grade = "First Class";
        } else if (percentage >= 50) {
            grade = "Second Class";
        } else if (percentage >= 35) {
            grade = "Pass Class";
        } else {
            grade = "Fail";
        }

        // Display
        System.out.println("\n************* Student Information *************");
        System.out.println("Roll Number          : " + rollNumber);
        System.out.println("Student Name         : " + firstName);
        System.out.println("Marks                : " + marks1 + " " + marks2 + " " + marks3 + " " + marks4 + " " + marks5);
        System.out.println("Total Marks          : " + total);
        System.out.println("Percentage           : " + percentage + "%");
        System.out.println("Grade                : " + grade);
        System.out.println("***********************************************");

        scan.close();
    }
}