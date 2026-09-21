package basics;

/* Java program to calculate the perimeter of a rectangle, square, and circle,
 * using BufferedReader for input.
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Perimeter {

    public static void main(String[] args) throws NumberFormatException, IOException{
        // Declarations
        double length, breadth, side, radius, perimeter;

        // Create BufferedReader object for taking input at runtime
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new java.io.BufferedReader(is);

        // Input for Rectangle
        System.out.println("Enter Length of Rectangle :");
        length = Double.parseDouble(br.readLine());
        System.out.println("Enter Breadth of Rectangle :");
        breadth = Double.parseDouble(br.readLine());
        
        // Calculate Perimeter of Rectangle
        perimeter = 2 * (length + breadth);

        // Output for Rectangle
        System.out.println("Perimeter of Rectangle : " + perimeter);
        
        
        String name;
        int age;

        System.out.println("Enter Your Name :");
        name = br.readLine();
        System.out.println("Enter Your Age :");
        age = Integer.parseInt(br.readLine());

        System.out.println("Hello " + name + " Your Age is : " + age);
        
        br.close();

    }
	/**
	 * Author :sushank2
	 * Date :04-Jul-2026
	 * Time :12:10:56 pm
	 * Email : saisushankindroji1476@gmail.com
	 */
}
