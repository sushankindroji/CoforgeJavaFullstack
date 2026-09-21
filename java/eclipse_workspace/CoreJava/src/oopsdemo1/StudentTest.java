package oopsdemo1;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :4:30:31 pm
 * Email : saisushankindroji1476@gmail.com
 */

public class StudentTest {
    
    public static void main(String[] args) {
        
        // Create Student Objects
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        
        // Invoke Instance class methods using dot operator
        s1.inputStudentDetails();
        s2.inputStudentDetails();
        s3.inputStudentDetails();
        
        float tot1 = s1.calculateTotalMarks();
        float tot2 = s2.calculateTotalMarks();
        float tot3 = s3.calculateTotalMarks();
        
        s1.displayStudentDetails();
        System.out.println("Display Total Marks returned to Main : " + tot1);
        s2.displayStudentDetails();
        System.out.println("Display Total Marks returned to Main : " + tot2);
        s3.displayStudentDetails();
        System.out.println("Display Total Marks returned to Main : " + tot3);
        
    }
}
