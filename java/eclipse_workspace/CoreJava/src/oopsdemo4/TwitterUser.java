/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :9:37:24 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo4;

public class TwitterUser implements TwitterOperations {

	// Attributes
	private int userId;
	private String userName;
	private String email;
	private boolean loginStatus;
	private int tweetCount;
	private int followingCount;
	private int totalLikes;

	public TwitterUser(int userId, String userName, String email) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
	}

	@Override
	public void login() {
		if (!loginStatus) {
			loginStatus = true;
			System.out.println(userName + " logged in successfully.");
		} else {
			System.out.println(userName + " is already logged in.");
		}


	}

	@Override
	public void postTweet(String tweet) {

		if (loginStatus) {

			tweetCount++;

			System.out.println("\nTweet Posted Successfully");
			System.out.println("Tweet : " + tweet);
			System.out.println("Total Tweets : " + tweetCount);

		} else {
			System.out.println("Please login first.");
		}

	}

	@Override
	public void likeTweet(int likes) {

		if (loginStatus) {

			totalLikes += likes;

			System.out.println("Received " + likes + " likes.");
			System.out.println("Total Likes : " + totalLikes);

		} else {
			System.out.println("Please login first.");
		}


	}

	@Override
	public void followUser(String username) {
		if (loginStatus) {

			followingCount++;

			System.out.println("Started following @" + username);
			System.out.println("Following : " + followingCount);

		} else {
			System.out.println("Please login first.");
		}


	}

	@Override
	public void logout() {



		if (loginStatus) {

			loginStatus = false;
			System.out.println(userName + " logged out successfully.");

		} else {
			System.out.println("User is already logged out.");
		}


	}

	// Display Profile
	public void displayProfile() {

		System.out.println("\n==============================");
		System.out.println("User ID         : " + userId);
		System.out.println("User Name       : " + userName);
		System.out.println("Email           : " + email);
		System.out.println("Tweets          : " + tweetCount);
		System.out.println("Following       : " + followingCount);
		System.out.println("Total Likes     : " + totalLikes);
		System.out.println("Login Status    : " + (loginStatus ? "Online" : "Offline"));
		System.out.println("==============================");
	}


}
