/**
 * 
 */
package controlflow;

/**
 * Author :sushank2
 * Date :04-Jul-2026
 * Time :4:01:39 pm
 * Email : saisushankindroji1476@gmail.com
 */


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Discount {

	/**
	 * @param args
	 * @throws NumberFormatException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		 	InputStreamReader is= new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			
	        String name;
	        int age;
	        boolean isMember;

	        //Ask user for Membership Status
	        System.out.println("Enter Your Name :");
	        name=br.readLine();
	        System.out.println("Enter Your Age: ");
	        age=Integer.parseInt(br.readLine());
	        System.out.println("Are You a Member ? : (true/false)");
	        isMember=Boolean.parseBoolean(br.readLine());

	        //Check if the user is eligible for discount
	        if(age < 18 || isMember) { //!Not operator Negates the Condition
	            System.out.println(name+" is Eligible for Discount !!!");
	        }
	        else {
	            System.out.println(name+" is Not Eligible for Discount !!!");
	        }

	}
	
}
