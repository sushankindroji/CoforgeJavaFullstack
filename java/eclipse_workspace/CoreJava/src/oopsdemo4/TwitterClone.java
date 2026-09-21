/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :9:49:02 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo4;

public class TwitterClone {

	public static void main(String[] args) {

		TwitterUser users[] = new TwitterUser[3];

		users[0] = new TwitterUser(101, "Rajashekar", "raja@gmail.com");
		users[1] = new TwitterUser(102, "Amit", "amit@gmail.com");
		users[2] = new TwitterUser(103, "Sneha", "sneha@gmail.com");

		for (TwitterUser user : users) {

			user.login();

			user.postTweet("Learning Java Interfaces.");
			user.postTweet("Today is a productive day!");

			user.followUser("OpenAI");
			user.followUser("Java");

			user.likeTweet(25);
			user.likeTweet(15);

			user.displayProfile();

			user.logout();
		}
	}
}
