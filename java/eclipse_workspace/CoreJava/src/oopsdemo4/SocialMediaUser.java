/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :10:05:42 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo4;

public class SocialMediaUser implements IUserOperations, ISocialFeatures {

	// Attributes
	private int userId;
	private String userName;
	private String email;
	private boolean loginStatus;
	private int totalPosts;
	private int totalFriends;
	private int totalLikes;

	// Constructor
	public SocialMediaUser(int userId, String userName, String email) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.loginStatus = false;
		this.totalPosts = 0;
		this.totalFriends = 0;
		this.totalLikes = 0;
	}

	@Override
	public void login() {
		if (!loginStatus) {
			loginStatus = true;
			System.out.println(userName + " logged into the Social Network.");
		} else {
			System.out.println(userName + " is already logged in.");
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

	@Override
	public void createPost(String post) {
		if (loginStatus) {
			totalPosts++;
			System.out.println("\nNew Post Created");
			System.out.println("Post : " + post);
			System.out.println("Total Posts : " + totalPosts);
		} else {
			System.out.println("Please login first to create a post.");
		}
	}

	@Override
	public void sendFriendRequest(String friendName) {
		if (loginStatus) {
			totalFriends++;
			System.out.println("Friend request sent to " + friendName);
			System.out.println("Total Friends : " + totalFriends);
		} else {
			System.out.println("Please login first.");
		}
	}

	@Override
	public void likePost(int likes) {
		if (loginStatus) {
			totalLikes += likes;
			System.out.println("Received " + likes + " likes.");
			System.out.println("Total Likes : " + totalLikes);
		} else {
			System.out.println("Please login first.");
		}
	}

	// Display Profile
	public void displayProfile() {
		System.out.println("\n==============================");
		System.out.println("User ID         : " + userId);
		System.out.println("User Name       : " + userName);
		System.out.println("Email           : " + email);
		System.out.println("Total Posts     : " + totalPosts);
		System.out.println("Total Friends   : " + totalFriends);
		System.out.println("Total Likes     : " + totalLikes);
		System.out.println("Login Status    : " + (loginStatus ? "Online" : "Offline"));
		System.out.println("==============================");
	}
}