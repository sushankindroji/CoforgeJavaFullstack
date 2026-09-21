/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :12:27:09 pm
 * Email : saisushankindroji1476@gmail.com
 */


package exceptionsdemo;

public class GeneralExceptionDemo {

	public static void main(String[] args) {

		String languages[] = { "C", "C++", "Java", "Perl", "Python" };

		try {
			for(int i=0;i<5;i++) {
				System.out.println(languages[i]);
			}
		}catch(Exception e) {
			e.printStackTrace(); //Details abt exception Name, Description,Line Number of code which generated exception
			System.out.println("Error Occured");
		}
		finally {
			System.out.println("In Finally Block- Program execution ended");
		}
	}

}