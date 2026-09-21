/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :10:24:15 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo4;

public class MultipleSocialNetworkingDemo {

	public static void main(String[] args) {

		SocialMediaUser[] users = new SocialMediaUser[3];

		users[0] = new SocialMediaUser(101, "Rajashekar", "raja@gmail.com");
		users[1] = new SocialMediaUser(102, "Amit", "amit@gmail.com");
		users[2] = new SocialMediaUser(103, "Sneha", "sneha@gmail.com");

		for (SocialMediaUser user : users) {

			user.login();

			user.createPost("Learning Java Interfaces.");
			user.createPost("Today is a productive day!");

			user.sendFriendRequest("OpenAI");
			user.sendFriendRequest("Java Developer");

			user.likePost(25);
			user.likePost(15);

			user.displayProfile();

			user.logout();

			System.out.println();
		}
	}
}