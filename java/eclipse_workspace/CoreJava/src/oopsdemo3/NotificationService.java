/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :11:03:30 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class NotificationService {

	private String companyName;
	private String senderName;

	//Default constructor
	public NotificationService() {
		companyName = "ABC Technologies";
		senderName = "System";
	}

	//Parametrized  Constructor
	public NotificationService(String companyName, String senderName) {
		this.companyName = companyName;
		this.senderName = senderName;
	}

	// Method 1
	public void sendNotification(String message) {
		System.out.println("Company : " + companyName);
		System.out.println("Sender  : " + senderName);
		System.out.println("SMS     : " + message);
	}

	// Method 2 (Overloaded)
	public void sendNotification(String email, String message) {
		System.out.println("Company : " + companyName);
		System.out.println("Sender  : " + senderName);
		System.out.println("Email   : " + email);
		System.out.println("Message : " + message);
	}

	// Method 3 (Overloaded)
	public void sendNotification(String email, String message, int priority) {
		System.out.println("Company : " + companyName);
		System.out.println("Sender  : " + senderName);
		System.out.println("Email   : " + email);
		System.out.println("Message : " + message);
		System.out.println("Priority: " + priority);
	}





}

